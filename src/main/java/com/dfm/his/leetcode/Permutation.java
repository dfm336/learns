package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列。 回溯算法
 *
 1、路径：也就是已经做出的选择。

 2、选择列表：也就是你当前可以做的选择。

 3、结束条件：也就是到达决策树底层，无法再做选择的条件。

 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 * @author dfm
 * @create 2020-09-21 16:30
 */
public class Permutation {
//    static List<List<Integer>> track = new LinkedList<>();
    /**
     *  1、路径：track记录
     *  2、选择列表：arr
     *  3、结束条件：arr中的数字 全部在 track出现.
     * @return
     */
   public static void backTrack(int[] arr,List<Integer> row,List<List<Integer>> track){
        if(row.size() == arr.length){
            track.add(new ArrayList<>(row));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(row.contains(arr[i]))continue;//已经使用过
            row.add(arr[i]);
            backTrack(arr,row,track);
            row.remove(row.size()-1);
        }
   }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> track = new ArrayList<>();
        backTrack(arr,row,track);
        track.forEach(x->x.forEach(t-> System.out.print(t+" ")));
    }
}
