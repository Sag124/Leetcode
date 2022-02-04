class Solution {
    public int findFinalValue(int[] nums, int original) {
       while (search(nums, original)) {
           original = original * 2;
       }
        return original;
    }
    
    public boolean search(int[] nums, int k) {
        boolean flag = false;
        for (int num : nums) {
            if (num == k) {
                flag = true;
            }
        }
        return flag;
    }
}