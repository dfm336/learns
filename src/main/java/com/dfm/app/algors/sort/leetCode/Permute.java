package com.dfm.app.algors.sort.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 典型回溯：
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
 * @Author:fengming.dai
 */
public class Permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案
     * https://leetcode-cn.com/problems/permutations/
     * @param nums
     * @return
     */
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    /**
     * 回溯
     * @param nums 可供选择列表（选择列表）
     * @param track  已经选择列表（路径）
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //结束条件 nums中的元素都被使用
        if (nums.length ==  track.size()){
            res.add(track);
            return;
        }

        for (int i = 0; i < nums.length; i++){
            //是否加入（没有被选过得 才进入）
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            backtrack(nums,track);
            //取消选择
            track.removeLast();
//            track.remove(track.size()-1);
        }
    }
}
