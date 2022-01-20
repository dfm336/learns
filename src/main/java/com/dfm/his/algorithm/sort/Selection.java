package com.dfm.his.algorithm.sort;

/**选择排序
 * 1. 每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如
 * 果当前索引处的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到
 * 最小值所在的索引
 * 2. 交换第一个索引处和最小值所在的索引处的值
 * @author dfm
 * @create 2020-08-20 15:57
 */
public class Selection {
    public void sort(int[] arr){
        //避免j = i+1越界，边界应为 len-1 ，最后一个不需要 排序，边界为 len-1
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    //交换i j
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
