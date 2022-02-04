class Solution {
    
    public void createRes(List<List<Integer>> res, List<List<Integer>> smallAns, int val) {
        for (List<Integer> sa : smallAns) {
            sa.add(val);
            res.add(sa);
        }
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int si, int ei) {
        List<List<Integer>> res = new ArrayList<>();
        while (si < ei) {
            int sum = nums[si] + nums[ei];
            if (sum > target) {
                ei--;
            } else if (sum < target) {
                si++;
            } else {
                ArrayList<Integer> sol = new ArrayList<>();
                sol.add(nums[si]);
                sol.add(nums[ei]);
                res.add(sol);
                si++;
                ei--;
                while (si < ei && nums[si] == nums[si-1]) si++;
                while (si < ei && nums[ei] == nums[ei + 1]) ei--;
            }
        }
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target, int si, int ei) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = si; i <= ei; i++) {
            if (i != si && nums[i] == nums[i-1]) continue;
            List<List<Integer>> smallAns = twoSum(nums, target - nums[i], i+1, ei);
            createRes(res, smallAns, nums[i]);
        }
        return res;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int si = 0;
        int ei = nums.length - 1;
        for (int i = si; i <= ei; i++) {
            if (i != si && nums[i] == nums[i-1]) continue;
            List<List<Integer>> smallAns = threeSum(nums, target - nums[i], i+1, ei);
            createRes(res, smallAns, nums[i]);
        }
        return res;
    }
}