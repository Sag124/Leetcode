class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, true);
        }
        
        for (int val : nums) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int max_len = 0;
        for (int val : nums) {
            if (map.get(val)) {
                int tl = 1;
                int ts = val;
                while (map.containsKey(ts + tl)) {
                    tl++;
                }
                
                if (tl > max_len) {
                    max_len = tl;
                }
            }
        }
        
        return max_len;
        
    }
}