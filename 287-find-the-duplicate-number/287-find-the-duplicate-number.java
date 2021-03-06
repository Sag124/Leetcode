class Solution {
    public int findDuplicate(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             if (map.get(nums[i]) > 1) return nums[i]; 
//         }
        
//         return -1;
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                dup = cur;
                break;
            }
            nums[cur] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return dup;
    }
}