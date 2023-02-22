package leetcode.editor.cn;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-02-22 15:01:19 
 */
 public class Q0046Permutations{
 //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2409, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0046Permutations().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

     List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> trace = new LinkedList<Integer>();
        boolean[] visit = new boolean[nums.length];
        backTrace(nums, trace,visit );
        return res;
    }

    public void backTrace(int[] nums, List<Integer> trace, boolean[] visit){
        if ( trace.size() == nums.length){
            res.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]){
                visit[i] = true;
                trace.add(nums[i]);
                backTrace(nums,trace,visit);
                //撤销
                trace.remove(trace.indexOf(nums[i]));
                visit[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }