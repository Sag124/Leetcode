class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Arrays.sort(boxTypes, (box1, box2) -> {
        //    int units_1 = box1[1];
        //    int units_2 = box2[1];
        //    if (units_1 < units_2) return 1; else return -1;
        // });
        
        
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
            
        int maxUnit = 0;
        for (int[] box : boxTypes) {
            int bc = Math.min(truckSize, box[0]);
            maxUnit += bc * box[1];
            truckSize -= bc;
            if (truckSize == 0) break;
        }
        
        return maxUnit;
       
    }
}