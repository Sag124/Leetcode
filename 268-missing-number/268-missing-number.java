class Solution {
    public int missingNumber(int[] nums) {
        // int sum = 0;
        // int n = nums.length;
        // for (int num : nums) {
        //     sum += num;
        // }
        // return (n * (n+1)) / 2 - sum;
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}