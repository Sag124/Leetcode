class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> res = new ArrayList<>();
         backtrack(res, "", 0, 0, n);
         return res;   
    }
    
    public void backtrack(List<String> res, String current, int start, int end, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }
        
        if (start < max) backtrack(res, current + "(", start + 1, end, max);
        if (end < start) backtrack(res, current + ")", start, end + 1, max);
    }
}