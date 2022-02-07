class Solution {
    public String firstPalindrome(String[] words) {
        // String res = "";
        // for (int i = 0; i < words.length; i++) {
        //     if (isPalin(words[i])) {
        //         res = words[i];
        //     }
        // }
        // return res;
        for (String w : words) {
            StringBuilder sb = new StringBuilder(w);
            if (sb.reverse().toString().equals(w)) {
                return w;
            }
        }
        return "";
    }
    
    public boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        
        return true;
    }
}