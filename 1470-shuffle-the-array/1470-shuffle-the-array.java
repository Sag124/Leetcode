class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int i = 0, j = n, k = 0;
        while (k < nums.length) {
            res[k++] = nums[i++];
            res[k++] = nums[j++];
            
        }
        return res;
    }
    
}