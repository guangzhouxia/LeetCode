package Array;

public class JumpGame {
    /*
    * Given an array of non-negative integers, you are initially positioned at the first index of the array.
    * Each element in the array represents your maximum jump length at that position.
    * Determine if you are able to reach the last index.
    * A = [2,3,1,1,4], return true.
    * A = [3,2,1,0,4], return false.
    * ps: 当前i元素的值表示能到的距离，问最终是否能到终点
    *
    * 思路：
    *   记录当前全局能到达的最远位置canReach（全局最优解），
    *   遍历数组，求每个i所能达到的最远位置（即局部最优解），同时更新全局最优解，
    *   期间要注意当前所在的i能否到达，可以通过canReach是否大于或等于i进行判断，
    *   最后判断canReach是否达到或超过数组终点。
    *
    *   时间复杂度O(n)，空间复杂度O(1)。
    *
    * */
    public static boolean canJump(int[] nums) {

        if (nums.length == 0) {
            return false;
        }

        int canReach = nums[0];//  存储目前全局能到达的位置

        for (int i=1; i<nums.length && i<=canReach; i++) {
            canReach = Math.max(canReach, nums[i] + i); // 更新能到达的位置
        }

        return canReach >= (nums.length - 1);
    }
}
