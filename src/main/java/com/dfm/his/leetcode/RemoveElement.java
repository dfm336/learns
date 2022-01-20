package com.dfm.his.leetcode;

/**
 * @author dfm
 * @create 2020-10-09 15:50
 */
public class RemoveElement {
    static int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};

    public static void main(String[] args) {
//        int ans = removeElenent(3);
        int ans = niceRemoveDuplicates();
        for(int i=0;i< ans ;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //双指针  间隔 1.  arr排好序
    public static int niceRemoveDuplicates(){
        int slow = 0;
        int fast = 1;
        while (fast < arr.length){
            if( arr[slow] != arr[fast]){
                arr[slow+1] = arr[fast];
                slow++;
            }else fast++;
        }
        // 数组长度为索引 + 1
        return slow+1;
    }

    public static int removeDuplicates(){
        int len = arr.length;
        int count = 0;
        for(int i=0;i<len-count-1;i++){
            if(arr[i] == arr[i+1]){
                count++;
                for(int j=i+1;j<len;j++){
                    arr[j-1] = arr[j];
                }
                i--;
            }
        }
        return len-count;
    }


    private static int removeElenent(int val) {
        int len =arr.length;
        int count = 0;
        //边界在改变，删了几个 少几个
        for(int i=0;i<len-count;i++){
            if(arr[i] == val  ){
                count++;
                for(int j=i+1;j<len;j++){
                    arr[j-1] = arr[j];
                }
                //后面的所有元素 往前移了一位。i就不需要++；
                i--;
            }
        }
        return len-count;
    }
}
