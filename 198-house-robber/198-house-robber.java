class Solution {
    public int rob(int[] nums) {
        int old_inc = nums[0];
        int old_exc = 0;
        for (int i = 1; i < nums.length; i++) {
            int new_inc = old_exc + nums[i];
            int new_exc = Math.max(old_inc, old_exc);
            
            old_inc = new_inc;
            old_exc = new_exc;
        }
        
        return Math.max(old_inc, old_exc);
    }
}