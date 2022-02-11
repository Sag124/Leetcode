class Solution {
    
    public boolean isAnagram(int[] s1_fq, int[] s2_fq) {
        for (int i = 0; i < 26; i++) {
            if (s1_fq[i] != s2_fq[i]) return false;
        } 
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1_fq = new int[26];
        int[] s2_fq = new int[26];
        
        int i;
        for (i = 0; i < s1.length(); i++) {
            s1_fq[s1.charAt(i) - 'a']++;
            s2_fq[s2.charAt(i) - 'a']++;
        }
        
        if (isAnagram(s1_fq, s2_fq)) {
            return true;
        }
        
        int start = 1;
        s2_fq[s2.charAt(0) - 'a']--;
        
        for (; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            s2_fq[ch - 'a']++;
            if (isAnagram(s1_fq, s2_fq)) {
                return true;
            }
            s2_fq[s2.charAt(start) - 'a']--;
            start++;
        }
        
        return false;
    }
}