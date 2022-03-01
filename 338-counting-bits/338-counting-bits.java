class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i < ans.length; i++) {
            String bin = Integer.toBinaryString(i);
            int count = 0;
            for (Character ch : bin.toCharArray()) {
                if (ch == '1') {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}