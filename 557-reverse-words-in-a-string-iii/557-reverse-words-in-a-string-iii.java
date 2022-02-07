class Solution {
    public String reverseWords(String s) {
        String[] split_s = s.split(" ");
        String res = "";
        for (int i = 0; i < split_s.length; i++) {
            if (i != split_s.length - 1) 
            res = res + reverse(split_s[i]) + " ";
            else
            res = res + reverse(split_s[i]);
        }
        return res;
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}