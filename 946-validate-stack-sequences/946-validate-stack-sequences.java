class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        // push till pushed[i] == popped[i]
        int j = 0;
        
        for (int val : pushed) {
            st.push(val);
            while (!st.isEmpty() && j < pushed.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        
        return j == pushed.length;
    }
}