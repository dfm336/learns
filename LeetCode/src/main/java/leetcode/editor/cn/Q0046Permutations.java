package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-02-07 17:46:51 
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
// 👍 2391, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0046Permutations().new Solution();
 	int[] nums = {1,2,3};
     List<List<Integer>> permute = solution.permute(nums);
     permute.forEach(itm->{
         itm.forEach(num-> System.out.print(num+" "));
         System.out.println();
     });
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

     List<List<Integer>> res = new LinkedList<>();

     public List<List<Integer>> permute(int[] nums) {
         //记录每次 路径
         LinkedList<Integer> track = new LinkedList<>();
         //每个数字 只能用一次
         boolean[] used = new boolean[nums.length];
        backtrace(used,track,nums);
        return res;
     }

     public void backtrace(boolean[] used, LinkedList<Integer> track, int[] nums){
         if (nums.length == track.size()){
             //注意不能直接把 track 添加进去。每次只会加上同一个 引用
             res.add(new LinkedList<>(track));
             return;
         }
         for (int i = 0; i < nums.length; i++) {

             if (used[i]){
                 continue;
             }
             //做选择
             track.add(nums[i]);
             used[i] = true;


             backtrace(used,track,nums);

             //取消选择
             int index = track.indexOf(nums[i]);
             track.remove(index);
             used[i] = false;
         }
     }
}
//leetcode submit region end(Prohibit modification and deletion)

 }