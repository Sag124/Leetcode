class Solution {
    public boolean canArrange(int[] arr, int k) {
        boolean flag;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int rem = val % k;
            if (rem < 0){
                rem += k;
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        for (int val : arr) {
            int rem = val % k;
            if (rem < 0) {
                rem += k;
            }
            if (rem == 0 || 2 * rem == k) {
                int fq = map.get(rem);
                if (fq%2 != 0) {
                    return false;
                }
            } else {
                int fq = map.get(rem);
                int ofq = map.getOrDefault(k-rem, 0);
                if (fq != ofq) {
                    return false;
                }
            }
        }
        return true;
    }
}