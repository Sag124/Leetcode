class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int totalSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            totalSum = Math.max(totalSum, curSum);
        }
        return totalSum;
    }
}