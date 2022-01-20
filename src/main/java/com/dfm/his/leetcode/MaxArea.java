package com.dfm.his.leetcode;


/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author dfm
 * @create 2020-09-11 15:25
 */
public class MaxArea {
    /**
     * 双 指针。从两端出发， s = 距离 *  高度。
     * 距离 已经是 从大到小了。
     * @param arr
     * @return
     */
    public static int nice(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int maxNum = 0;
        while (left < right) {
            int s = Math.min(arr[left], arr[right]) * (right - left);
            maxNum = (s > maxNum) ? s : maxNum;
            //高度 比较小的 继续移动。才可能提高 短板 高度
            int  x  = (arr[left] < arr[right] ) ? left++ : right--;
        }
        return maxNum;
    }
    /**
     * 暴力计算。
     */
    public static int solution(int[] height){
        int n = height.length;
        int max  = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int s = Math.min(height[i],height[j]) * (j-i);
                if(s > max)max = s;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int solution = nice(arr);
        System.out.println(solution);
    }
}
