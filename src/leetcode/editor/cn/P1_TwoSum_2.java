package leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
// 你可以按任意顺序返回答案。 
// 
// 示例 1： 
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
// 示例 2： 
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
// 示例 3： 
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
// 
// 提示： 
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10028 👎 0

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 */
public class P1_TwoSum_2 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            //建立长度-1的哈希表（因为最后一个的时候肯定能找到）
            HashMap<Integer, Integer> hashMap = new HashMap<>(len - 1);
            //对数组进行遍历
            for (int i = 0; i < len; i++) {
                //当符合目标的结果存在于哈希表中时，取出并返回
                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{hashMap.get(target - nums[i]), i};
                }
                //将当前的目标存入哈希表
                hashMap.put(nums[i], i);
            }
            throw new IllegalArgumentException("No solution!");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1_TwoSum_2().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4, 5, 6, 7}, 12)));
    }
}