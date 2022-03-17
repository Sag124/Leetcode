class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ans);
                ans = 0;
            } else if (ch == ')') {
                ans = st.pop() + Math.max(1, 2 * ans);
            }
        }
        return ans;
    }
}

//
// "(()(()))"