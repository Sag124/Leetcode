class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
        
    }
    
    public int rob_simple(int[] nums, int start, int end) {
        int old_inc = nums[start];
        int old_exc = 0;
        
        for (int i = start + 1; i <= end; i++) {
            int new_inc = old_exc + nums[i];
            int new_exc = Math.max(old_inc, old_exc);
            
            old_inc = new_inc;
            old_exc = new_exc;
        }
        
        return Math.max(old_inc, old_exc);
    }
}