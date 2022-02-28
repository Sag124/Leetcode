class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int mins = Math.min(truckSize, boxType[0]);
            res += mins * boxType[1];
            truckSize -= mins;
            if (truckSize == 0) {
                break;
            }
        }
        
        return res;
    }
}