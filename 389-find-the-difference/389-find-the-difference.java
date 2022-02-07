class Solution {
    public char findTheDifference(String s, String t) {
        int oc = 0;
        int nc = 0;
        for (int i = 0; i < s.length(); i++) {
            oc += (int)s.charAt(i);
        }
        
        for (int i = 0; i < t.length(); i++) {
            nc += (int)t.charAt(i);
        }
        
        return (char)(nc - oc);
    }
}