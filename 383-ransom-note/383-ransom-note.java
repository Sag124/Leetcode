class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> rmap = new HashMap<>();
        HashMap<Character, Integer> mmap = new HashMap<>();
        
        for (Character ch : ransomNote.toCharArray()) {
            rmap.put(ch, rmap.getOrDefault(ch, 0) + 1);
        }
        
        for (Character ch : magazine.toCharArray()) {
            mmap.put(ch, mmap.getOrDefault(ch, 0) + 1);
        }
        
        for (Character ch : rmap.keySet()) {
            int rcount = rmap.get(ch);
            int mcount = mmap.getOrDefault(ch, 0);
            
            if (mcount < rcount) {
                return false;
            }
        }
        
        return true;
    }
}