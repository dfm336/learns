package com.dfm.his.algorithm.collections;


/**Java中使用byte[]字节数组来存储bit,1Byte = 8bit。对于bit中的第i位，
 * 该bit为1则表示true，
 * 即数据存在；为0则表示false，即数据不存在。
 * @author dfm
 * @create 2020-11-03 14:22
 */
public class BitMap {
    private byte[] bytes;
    private  int length;
    public BitMap(int length){
        this.length = length;
        bytes = new byte[length/8+1];
    }

    public boolean get(int index){
        if(index < 0 || index > length){
            System.out.println("Error index");
        }
        int position = index & 7;//等价于index%8,得到目标bit在该Byte中的位置。

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bytes[index >> 3] & ( 1 << position)) != 0;
    }

    public void set(int index ,boolean value){
        if(value){
            //index >> 3找到 属于第几个 byte，   index & 7 等价于 index % 8,找到 属于第n个byte上的 第几个bit
            // 1 << ( index & 7)  将 该位置 置1. 其他位置 置0了，为了不改变 原来数据，所以 用 | 操作
            bytes[index >> 3] |= 1 << (index & 7);
        }else {
            //~(1 << (index & 7));  将该位置 置0，其他位置 置1了，为了不改变 原来数据 所以 用 & 操作
            bytes[index >> 3] &= ~(1 << (index & 7));
        }
    }
}
class Test{
    public static void main(String[] args) {
        BitMap bitMap = new BitMap(16);
        bitMap.set(3,true);
        bitMap.set(2,true);
        bitMap.set(15,true);
        bitMap.set(1,false);
        bitMap.set(16,true);
        for(int i=1;i<= 16;i++){
            System.out.println(i+": "+bitMap.get(i));
        }
    }
}
