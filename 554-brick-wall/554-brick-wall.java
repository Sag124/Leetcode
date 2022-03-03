class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (freq > count) {
                count = freq;
            }
        }
        
        return wall.size() - count;
    }
}