class Solution {
    
    public void addTo(List<List<Integer>> res, List<List<Integer>> sub, int k) {
        for (List<Integer> su : sub) {
            su.add(k);
            res.add(su);
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> sub = twoSum(nums, i+1, nums.length - 1, 0 - nums[i]);
            addTo(res,sub, nums[i]);
        }
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(nums[start]);
                result.add(nums[end]);
                res.add(result);
                start++;
                end--;
                
                while (start < end &&  nums[start] == nums[start - 1]) start++;
                while (start < end &&  nums[end] == nums[end + 1]) end--;
            }
        }
        return res;
    }
}