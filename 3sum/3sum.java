class Solution {
    
    public void sol(List<List<Integer>> res, List<List<Integer>> subp, int k) {
        for (List<Integer> sub : subp) {
            sub.add(k);
            res.add(sub);
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int si = 0;
        int ei = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> subp = twoSum(nums, 0 - nums[i], i+1, nums.length - 1);
            sol(res, subp, nums[i]);
        }
        return res;
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
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[si]);
                temp.add(nums[ei]);
                res.add(temp);
                si++;
                ei--;
                while (si < ei && nums[si] == nums[si - 1]) si++;
                while (si < ei && nums[ei] == nums[ei + 1]) ei--;
            }
        }
        return res;
    }
}