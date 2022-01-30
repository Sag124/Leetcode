class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        
        int d = (max - min) / (arr.length - 1);
        
        for (int i = 0; i < arr.length; i++) {
            int val = min + i * d;
            if (!set.contains(val)) {
                return false;
            }
        }
        
        return true;
    }
}