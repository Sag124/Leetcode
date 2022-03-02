class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        int sleft = 0, tleft = 0;
        while (sleft < s.length() && tleft < t.length()) {
            if (s.charAt(sleft) == t.charAt(tleft)) {
                sleft++;
            }
            tleft++;
        }
        return sleft == s.length();
    }
}