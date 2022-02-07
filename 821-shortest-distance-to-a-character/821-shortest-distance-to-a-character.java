class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        ArrayList<Integer> res = findAll(s, c);
        for (int i = 0; i < ans.length; i++) {
            // compare i with findAll
            int min = Integer.MAX_VALUE;
            for (int re : res) {
                if (Math.abs(i - re) < min) {
                    min = Math.abs(i - re);
                }
            }
            ans[i] = min;
        }
        return ans;
    }
    
    public ArrayList<Integer> findAll(String s, char c) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                res.add(i);
            }
        }
        return res;
    }
}