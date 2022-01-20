package com.dfm.his.nowcode;

import java.util.*;

/**给定一个非空的整数数组，从数组第一个元素(下标为0的元素)开始遍历进行移动，下一次向后或向前移动 该元素的值 的位数（值为正数向后移动，值为负数向前移动，值为零不移动），依次类推进行移动，若某次移动数组出现越界，则说明数组可以跳出，返回true；不能跳出则返回false；（加分项：也可考虑不增加使用其他集合数组辅助完成算法）
 例1：
 输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
 例2：
 输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,再次向前移动3位后,向前数组越界,即跳出数组,输出true;
 * @author dfm
 * @create 2020-09-17 09:18
 */
public class Main {
    public static boolean solution(Integer[] arr){
        int n = arr.length;
        int i = 0;
        int flag = 0;
        while ( true ){
            i += arr[i];
            flag ++;
            if( i >= n || i < 0)return true;
            if(flag >= n)return false;
        }
    }

    /**
     * 给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
     * 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
     * @param arr
     * @return
     */
    public static int findMajorElement(Integer[] arr){
        int n =arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++ ){
            map.put(arr[i],0);
        }
        for(int i=0;i<n;i++ ){
            map.put(arr[i],map.get(arr[i])+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() > n/2)return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = new int[split.length];
        for(int i=0;i<split.length;i++){
            list.add(Integer.valueOf(split[i]));
            nums[i] = Integer.valueOf(split[i]);
        }

        Integer[] arr = new Integer[list.size()];
//        list.toArray(arr);
//        Arrays.sort(arr);
//        System.out.println(arr[arr.length-3]);
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
//        int result = findMajorElement(arr);
        boolean result = solution(arr);
        System.out.println(result);
//        int[] arr = new int[3];
//        int count =0;
//        int size =3;
//        while (scanner.hasNextInt()){
//            if(count >= size){
//                size*=2;
//                int[] tem = new int[size];
//                tem  = arr.clone();
//                arr = new int[size];
//                for(int i=0;i<tem.length;i++){
//                    arr[i] = tem[i];
//                }
//
//            }
//           arr[count] = scanner.nextInt();
//           count++;
//        }
//        int majorElement = findMajorElement(arr);
//        System.out.println(majorElement);
    }

}
