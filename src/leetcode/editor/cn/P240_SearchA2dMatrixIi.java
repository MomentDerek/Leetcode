package leetcode.editor.cn;
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
// 
// 示例 1：
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
// 示例 2：
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
// 
// 提示： 
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 二分查找 分治算法 
// 👍 513 👎 0

/**
 *搜索二维矩阵 II
 */
public class P240_SearchA2dMatrixIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        //取左下角的数
        int nowY = matrix.length-1, nowX = 0;
        //当超过范围的时候，意味着找不到了
        while (nowY >= 0 && nowX < matrix[0].length) {
            //取数作对比
            int now = matrix[nowY][nowX];
            //目标比当前的数大，向右移动
            if (target>now ) {
                nowY--;
            }
            //目标比当前的数小，向上
            else if (  target<now) {
                nowX++;
            } else {
                return true;
            }
        }
        return false;
    }
}
//为什么超出范围就意味着找不到了呢？
//每次向上移动一次，都意味着这行的数都比目标要大（注意之前已经被排除的数不算，该行比这个数小的数都因为向右的移动被排除了），那这一行的数都将被排除出去
//同理，每次右移动一次，都意味着当前列的数都比目标小
//那么，当出了范围后，意味着所有的数都被排除了，所以就是找不到了
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P240_SearchA2dMatrixIi().new Solution();
	 	 System.out.println(solution.searchMatrix(new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}},20));
	 }
}