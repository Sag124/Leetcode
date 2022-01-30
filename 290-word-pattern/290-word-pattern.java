class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) { 
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (used.containsKey(words[i])) {
                    return false;
                } else {
                    used.put(words[i], true);
                    map.put(ch, words[i]);
                }
            } else {
                // 
                String res = map.get(ch);
                if (!res.equals(words[i])) {
                    return false;
                } 
            } 
            
        }
        return true;
    }
}