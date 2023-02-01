package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  fengming.dai 
 * @date    2022-11-22 16:01:30 
 */
 public class Q0001TwoSum{
 //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 15832 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0001TwoSum().new Solution();
 	int[] nums = {2,3,11,-1};
 	int target = 10;
 	int[] res = solution.twoSum(nums, target);
 	System.out.println(String.format("res:%d,%d", res[0],res[1]));
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        //key : target - nums[i], value = index
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = target - nums[i];
            if (null != map.get(key)){
                res[0] = i;
                res[1] = map.get(key);
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
 }