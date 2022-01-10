class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum - k;
            if (map.containsKey(key)) {
                count += map.get(key); 
            } 
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        
        return count;
    }
}