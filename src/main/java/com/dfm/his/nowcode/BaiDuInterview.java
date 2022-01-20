package com.dfm.his.nowcode;

/**
 * @author dfm
 * @create 2020-10-23 14:14
 */
public class BaiDuInterview {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,4,8,7,3,5,7};
        putLocation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(i+": "+arr[i]+" ");
        }
    }
    /**
     * 给定一个长度位2N的数组，奇数和偶数个数相同，实现一个算法，使得奇数放在奇数位，偶数放在偶数位。
     * 从最后一个节点访问，slow始终指向 下标 为 偶数，fast 始终 指向 下标 为 奇数
     * 判断 len-1的元素，判断 奇偶后，跟前面 slow，fast元素 换位。
     * @param arr
     */
    public static void putLocation(int[] arr){
        int slow = 0;
        int fast = 1;
        int end = arr.length-1;
        while (slow < arr.length  &&  fast < arr.length){
            if(arr[end] % 2 ==0){
                int t = arr[end];
                arr[end] = arr[slow];
                arr[slow] = t;

                slow+=2;
            }else {
                int t = arr[end];
                arr[end] = arr[fast];
                arr[fast] = t;

                fast+=2;
            }
        }
    }
}
