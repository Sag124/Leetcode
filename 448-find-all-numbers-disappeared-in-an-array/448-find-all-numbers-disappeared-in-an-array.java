class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int new_index = Math.abs(nums[i]) - 1;
            if (nums[new_index] > 0) {
                nums[new_index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}