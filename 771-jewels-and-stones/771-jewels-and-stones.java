class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            int in = jewels.indexOf(stones.charAt(i));
            if (in != -1) count++;
        }
        return count;
    }
}