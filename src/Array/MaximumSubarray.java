package Array;

// LeetCode 53.Maximum Subarray
public class MaximumSubarray {

    /*

    * Find the contiguous subarray within an array (containing at least one number)
    * which has the largest sum.
    * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
    *
    * 找出数组里面连续子序列的sum最大值。
    * 比如[-2,1,-3,4,-1,2,1,-5,4]
    * [4,-1,2,1], 最大值为6
    *
    * 调用：MaximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})
    *
    * 动态规划类题目。
    * 每一步遍历中维护一个全局最优解globalMax 和 到当前元素的最优解localMax
    *
    * 具体思路：当遍历到坐标为i的元素时，算出其当前元素结尾的最优解。
    *         当前局部最优解(以当前元素结尾)有两种可能：
    *         A. localMax(i) = localMax(i-1) + a[i], (localMax(i-1)>=0),
    *         B. localMax(i) = a[i], (localMax(i-1)<0),
    *         这里可以得到局部最优解:
    *          localMax(i) = Max{localMax(i-1) + a[i], a[i]}，
    *         同时维护全局最优解：
    *          globalMAX[i] = Max{globalMAX[i-1], localMax[i]}
    *
    *         globalMAX便是当前连续子序列最大值的答案。
    *
    *         时间复杂度O(n),空间复杂度O(1)
    * */
    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) return 0;

        int globalMax = nums[0], localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax+nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
