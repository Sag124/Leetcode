class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        int limit = (int)Math.pow(2, n);
        // System.out.println((int)Math.pow(2, n));
        // System.out.println((int)Math.pow(2, n + 1));
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); i++) {
              String bitmask = Integer.toBinaryString(i).substring(1);
              List<Integer> cur = new ArrayList<>();
              for (int j = 0; j < n; j++) {
                  if (bitmask.charAt(j) == '1') {
                      cur.add(nums[j]);
                  }
              }
            res.add(cur);
        }
        return res;
    }
    
    
}