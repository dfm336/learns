Redis 为什么那么快？

除了它是内存数据库，使得所有的操作都在内存上进行之外，
还有一个重要因素，**它实现的数据结构，使得我们对数据进行增删查改操作时，Redis 能高效的处理**。

>注意，Redis 数据结构并不是指 
> String（字符串）对象、List（列表）对象、Hash（哈希）对象、Set（集合）对象和 Zset（有序集合）对象
> ，因为这些是 Redis 键值对中值的数据类型，也就是数据的保存形式，这些对象的底层实现的方式就用到了数据结构。

![img.png](images/redis数据类型与数据结构关系.png)
左边是 Redis 3.0版本的，也就是《Redis 设计与实现》这本书讲解的版本，现在看还是有点过时了，右边是现在 Github 最新的 Redis 代码的（还未发布正式版本）。

可以看到，Redis 数据类型的底层数据结构随着版本的更新也有所不同，比如：
- 在 Redis 3.0 版本中 List 对象的底层数据结构由「双向链表」或「压缩表列表」实现，但是在 3.2 版本之后，List 数据类型底层数据结构是由 quicklist 实现的；
- 在最新的 Redis 代码（还未发布正式版本）中，压缩列表数据结构已经废弃了，交由 listpack 数据结构来实现了

![img.png](images/redis数据机构思维导图.png)

我们都知道redis是一个 k-v 数据库。
Redis 的键值对中的 key 就是字符串对象，而 value 可以是字符串对象，也可以是集合数据类型的对象，比如 List 对象、Hash 对象、Set 对象和 Zset 对象。

Q:这些键值对是如何保存在 Redis 中的呢？
A: redis 采用了一个 **【hash表】** 来保存所有键值对，最大好处就是可以 O(1) 来快速查找键值对。

哈希表 其实是一个 数组，数组中的元素 是 哈希桶。

那么 redis中的 哈希桶 是怎么保存数据的呢？
如图：
![img.png](images/redis-db保存数据关系图.png)

- redisDb结构。 表示 redis 数据库的结构。 结构体 里面包含了一个 指向dict 的指针。
- dict结构， 结构体里 存放了  2个 哈希表。 （hash表 就是 dicht 结构）
    - 正常情况都是 用 ht[0] （第一个哈希表）， ht[1]（第二个哈希表）在 rehash 的时候才会使用到。
- ditcht结构， 也就是 存储键值对的 哈希表。结构包含指向 一个哈希表数组 的指针。
- dictEntry机构，表示 hash表 节点的机构。存放的就是 key，value 的指针。 
    - key 指向的是 String 对象
    - 而 value 则可以指向 String 对象，也可以指向集合类型的对象，比如 List 对象、Hash 对象、Set 对象和 Zset 对象。


特别说明下，void *key 和 void *value 指针指向的是 Redis 对象，Redis 中的每个对象都由 **redisObject 结构**表示，如下图： 
![img.png](images/redisObject示意图.png)

对象结构里包含的成员变量：
- type，标识该对象是什么类型的对象（String 对象、 List 对象、Hash 对象、Set 对象和 Zset 对象）；
- encoding，标识该对象使用了哪种底层的数据结构；
- ptr，指向底层数据结构的指针

![img.png](images/redis键值对全景图.png)


# SDS
字符串在 Redis 中是很常用的，键值对中的键是字符串类型，值有时也是字符串类型。

Redis 是用 C 语言实现的，但是它没有直接使用 C 语言的 char* 字符数组来实现字符串，而是自己封装了一个名为简单动态字符串（simple dynamic string，SDS） 的数据结构来表示字符串，
也就是 **Redis 的 String 数据类型的底层数据结构是 SDS**

既然 Redis 设计了 SDS 结构来表示字符串，肯定是 C 语言的 char* 字符数组存在一些缺陷。
要了解这一点，得先来看看 char* 字符数组的结构。

## C语言字符串缺陷

- 获取字符串长度 需要 时间复杂度O(N)
- 不能记录"\0"字符，因为 以 "\0"表示字符串结尾。 所以也就不能保持 二进制数据。
- 字符串操作 不高效 且不安全。有缓冲区溢出风险


```C
//将 src 字符串拼接到 dest 字符串后面
char *strcat(char *dest, const char* src);
```
>C 语言的字符串是不会记录自身的缓冲区大小的，所以 strcat 函数假定程序员在执行这个函数时，已经为 dest 分配了足够多的内存，
> 可以容纳 src 字符串中的所有内容，而一旦这个假定不成立，就会发生缓冲区溢出将可能会造成程序运行终止


## SDS结构设计
```c
struct __attribute__ ((__packed__)) sdshdr64 {
    uint64_t len; /* used */
    uint64_t alloc; /* excluding the header and null terminator */
    unsigned char flags; /* 3 lsb of type, 5 unused bits */
    char buf[];
};
```
![img.png](images/sds结构.png)
- len 记录字符串长度。这样获取字符串长度的时候，只需要返回这个成员变量值就行，时间复杂度只需要 O（1）
- alloc 分配给 buf数组的空间长度。
  - 这样连接或者修改 字符串的 时候，就能 通过 free = alloc - len 得出剩余空间，来判断是否需要扩容
  - 所以使用 SDS 既不需要手动修改 SDS 的空间大小，也不会出现前面所说的缓冲区溢出的问题。
- flags 用来标识不同类型的 SDS。分别是： sdshdr5、sdshdr8、sdshdr16、sdshdr32 和 sdshdr64
- buf[] 字符数组，用来报存实际的数据。 不仅可以 字符串， 也可以  存 二进制数据

> 因为SDS 有len来记录长度，不需要 使用 '\0' 标记字字符串结束，可以存储 '\0' 。所以 可以存储 二进制数据
> 但是 为了 兼容 c语言 标准库的函数， sds 也会在字符串尾部加上 '\0' 。

因为 SDS是能存储 二进制数据的，所以 SDS 的 API 都是以处理二进制的方式来处理 SDS 存放在 buf[] 里的数据，
程序不会对其中的数据做任何限制，数据写入的时候时什么样的，它被读取时就是什么样的。


SDS扩容：
```
hisds hi_sdsMakeRoomFor(hisds s, size_t addlen)
{
    ... ...
    // s目前的剩余空间已足够，无需扩展，直接返回
    if (avail >= addlen)
        return s;
    //获取目前s的长度
    len = hi_sdslen(s);
    sh = (char *)s - hi_sdsHdrSize(oldtype);
    //扩展之后 s 至少需要的长度
    newlen = (len + addlen);
    //根据新长度，为s分配新空间所需要的大小
    if (newlen < HI_SDS_MAX_PREALLOC)
        //新长度<HI_SDS_MAX_PREALLOC 则分配所需空间*2的空间
        newlen *= 2;
    else
        //否则，分配长度为目前长度+1MB
        newlen += HI_SDS_MAX_PREALLOC;
       ...
}
```


- 如果所需要的 sds 长度 小于 1m， 那么 就按照 新字符串长度 * 2 来扩容
- 如果需要的 sdsc长度 大于 1m， 那么就 在 新字符串长度 + 1M 扩容

扩容前 会先检查 未使用 空间是否足够，b不够的话 ，不仅 会分配 足够的空间，还会 为 sds 分配 额外的  未使用空间。
这样 就 减少 了  内存分配 次数

## 节省内存空间

SDS 结构中有个 flags 成员变量，表示的是 SDS 类型。

Redis 一共设计了 5 种类型，分别是 sdshdr5、sdshdr8、sdshdr16、sdshdr32 和 sdshdr64。

这 5 种类型的主要区别就在于，它们数据结构中的 len 和 alloc 成员变量的数据类型不同
例如：
```
struct __attribute__ ((__packed__)) sdshdr16 {
    uint16_t len;
    uint16_t alloc; 
    unsigned char flags; 
    char buf[];
};


struct __attribute__ ((__packed__)) sdshdr32 {
    uint32_t len;
    uint32_t alloc; 
    unsigned char flags;
    char buf[];
};
```

- sdshdr16 类型的 len 和 alloc 的数据类型都是 uint16_t，表示字符数组长度和分配空间大小不能超过 2 的 16 次方。
- sdshdr32 则都是 uint32_t，表示表示字符数组长度和分配空间大小不能超过 2 的 32 次方。


除了设计不同类型的结构体，Redis 在编程上还使用了专门的编译优化来节省内存空间，
即在 **struct 声明了 __attribute__ ((packed)) ，它的作用是：告诉编译器取消结构体在编译过程中的优化对齐，按照实际占用字节数进行对齐**。


# 链表



