class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int value = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            res.append(value);
            i--;
            j--;
        }
        
        if (carry != 0) {
            res.append(carry);
        }
        
        return res.reverse().toString();
        
    }
}