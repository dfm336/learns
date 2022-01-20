package com.dfm.his.nowcode;

import java.util.*;

/**
 * @author dfm
 * @create 2020-10-12 09:02
 */
public class Baidu2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int n1 = operNum(arr);
        System.out.println(n1);
    }
    /**
     * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
     * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
     *
     * 输入描述:
     * 输入一个正整数N, N <= 50。
     *
     * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
     *
     * 输出描述:
     * 输出一个整数表示度度熊最少需要走的距离。
     *
     * 输入例子1:
     * 4
     * 1 4 -1 3
     *
     * 输出例子1:
     * 4
     */
    /**
     * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
     * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
     * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
     *
     * 输入描述:
     * 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)
     *
     * 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)
     *
     * 输出描述:
     * 输出一个数表示最大的三角形面积，保留5位小数。
     */


    /**
     * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
     *
     * 输入描述:
     * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
     *
     * 输出描述:
     * 输出满足条件的排列数,答案对2017取模。
     * @param arr
     * @return
     */


    /**
     *度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
     * 任取数组中的一个数然后将它放置在数组的最后一个位置。
     * 问最少操作多少次可以使得数组从小到大有序？
     *
     * 输入描述:
     * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
     *
     * 输出描述:
     * 输出一个整数表示最少的操作次数。
     *
     * 输入例子1:
     * 4
     * 19 7 8 25
     *
     * 输出例子1:
     * 2
     * @param arr
     * @return
     */
    public static int operNum(int[] arr){
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int count = 0;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > clone[index]){
                count++;
                int t = arr[i];
                for (int j= 1;j<arr.length;j++){
                    arr[j-1] = arr[j];
                }
                arr[arr.length-1] = t;

                i--;
            }
            else {
                index++;
            }
        }
        return count;
    }


    /**
     * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
     *
     * 输入描述:
     * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
     *
     * 输出描述:
     * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
     *
     * 输入例子1:
     * 10
     * 10 10 10 10 20 20 30 30 40 40
     *
     * 输出例子1:
     * 30
     * @param n
     * @param arr
     * @return
     */
    public static int findN(int n,int[] arr){
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            treeMap.put(arr[i],arr[i]);
        }
        Set<Map.Entry<Integer, Integer>> entries = treeMap.entrySet();
        int count = 0;
        for (Map.Entry<Integer,Integer> entry:entries){
            count++;
            if(count == 3){
                return entry.getValue();
            }
        }
        return -1;
    }
}
