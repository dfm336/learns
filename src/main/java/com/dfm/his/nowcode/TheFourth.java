package com.dfm.his.nowcode;



import java.util.*;

/**
 * @author dfm
 * @create 2020-09-18 10:13
 */
public class TheFourth {
    public static String reverse(String str,String target){
        for(int i=0;i<str.length();i++){
            String substring = str.substring(i, str.length());
            String substring1 = str.substring(0, i);
            if((substring+substring1).equals(target))return "True";
        }
        return "False";
    }
//    public static int coins(int[] arr,int target,int index,int total,int count){
//        if(target == total+arr[index]){
//            count++;
//        }
// #include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//int main(){
//    const int mod = 1000000007;
//    int n,k;
//    cin>>n>>k;
//    vector<int>coins(k);
//    for(int i=0;i<k;i++){
//        cin>>coins[i];
//    }
//    sort(coins.begin(),coins.end());
//    vector<long long>dp(n+1,0);
//    dp[0] = 1;
//    for (int i = 0; i<k; i++) {
//        for (int j = coins[i]; j<n+1; j++) {
//            dp[j] += dp[j - coins[i]] % mod;
//        }
//    }
//    cout<<dp[n]%mod;
//    return 0;
//}
////        if(target arr[index])
//    }

    public static Long coins2(int[] arr,int target){
        int len =arr.length;
        long[][] dp = new long[len+2][target+1];
        for(int i=1;i<target;i++){
            dp[0][i]= 0;////用0种硬币凑成i元的组合数为0
        }
        for(int i=0;i<len;i++){
            dp[i][0] = 1;//用i种硬币凑成0元的组合数为1
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]=0;
                for(int k=0; k <= j/arr[i-1];k++){
                    dp[i][j] = dp[i-1][j - k*arr[i-1]];
                }
            }
        }
        return dp[len][target];
    }

    public static void cin(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        LRUcache<Long, Long> lru = new LRUcache<Long, Long>(m);
        for(int i=0;i<n;i++){
            String operator = in.next();
            if(operator.equals("PUT")){
                long x = in.nextInt();
                long y = in.nextInt();
                lru.put(x,y);
            }
            if(operator.equals("GET")){
                long x = in.nextInt();
                if(lru.containsKey(x)) System.out.println(lru.get(x));
                else System.out.println("-1");
            }
        }
    }
    public static void main(String[] args) {
        double random1 = Math.random();
        Random random = new Random(1);
        int i = random.nextInt(9);
        System.out.println(i);
//        cin();
       Scanner in = new Scanner(System.in);
        String strA = in.next();
        String strB = in.next();
        Long longest = Multiplay(strA,strB);
        System.out.println(longest);

//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] arr = new int[m];
//        for(int i=0;i<m;i++){
//            arr[i] = in.nextInt();
//        }
//        Arrays.sort(arr);
//        System.out.println(coins2(arr,n));
//        String strA = in.next();
//        String strB = in.next();
//        String reverse = reverse(strA, strB);
//        System.out.println(reverse);
    }

    private static Long Multiplay(String strA, String strB) {
        Long a = Long.valueOf(strA);
        Long b = Long.valueOf(strB);
        return  a * b;
    }

    private static String longest(String str) {
        int len = str.length();
        if(len <= 1)return str;
        String result = "";
        int max =0;
        for(int i=0;i<len-1;i++){
            int left = i;
            int right = i+1;
            String t = "";
            while (left>=0 && right < len && str.charAt(left) == str.charAt(right)){
                t += str.charAt(left);
                left--;
                right++;
            }
            if(t != "" && t.length()>max){
                result = t;
                max = t.length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder(result);
        StringBuilder reverse = stringBuilder.reverse();
        result = reverse +result;
        return result;
    }
}
 class LRUcache<k,v> extends LinkedHashMap<k,v> {

    private final int CHACHE_SIZE;

    /**
     * 传递进来 最多能缓存多少数据
     *
     * @param chacheSize 缓存大小
     */
    public LRUcache(int chacheSize) {
        //true 表示让 linkedHashMap 按照访问 顺序进行排序  最近访问的放在头部，最老 访问的放在尾部
//        super((int) (Math.ceil(chacheSize / 0.75) + 1), 0.75f, true);
        super( chacheSize, 0.75f, true);
        CHACHE_SIZE = chacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        //当数据量 > 指定的缓存大小,则清除 最老的数据
        return size() > CHACHE_SIZE;
    }
}
