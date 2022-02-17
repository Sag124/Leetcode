class Solution {
    
    public int potentialCandidate(int[] nums) {
        int value = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value) {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                value = nums[i];
                count = 1;
            }
        }
        
        return value;
    }
    
    public int majorityElement(int[] nums) {
        int val = potentialCandidate(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        int res = 0;
        if (count > nums.length / 2) {
            res = val;
        }
        
        return res;
    }
}