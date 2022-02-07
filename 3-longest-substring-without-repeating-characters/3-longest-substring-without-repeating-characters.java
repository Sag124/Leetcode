class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && start <= map.get(ch)) {
                start = map.get(ch) + 1;
            } else {
                maxLen = Math.max(maxLen, (i - start + 1));
            }
            map.put(ch, i);
        }
        
        return maxLen;
    }
}