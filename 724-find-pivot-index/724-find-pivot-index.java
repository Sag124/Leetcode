class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int left_sum = 0;
        int right_sum = sum;
        int index = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left_sum = left_sum + nums[i - 1];
            } 
            right_sum = right_sum - nums[i];
            if (left_sum == right_sum) {
                return i;
            }
        }
        
        return index;
    }
}