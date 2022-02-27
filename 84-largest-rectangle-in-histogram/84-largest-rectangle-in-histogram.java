class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rb = new int[heights.length]; // next smaller index on the right
        Stack<Integer> st = new Stack<>();
        rb[heights.length - 1] = heights.length;
        st.push(heights.length - 1);
        
        for (int i = heights.length - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        
        
        int[] lb = new int[heights.length]; // next smaller index on the left
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);
        
        for (int i = 1; i < heights.length; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * heights[i];
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
}