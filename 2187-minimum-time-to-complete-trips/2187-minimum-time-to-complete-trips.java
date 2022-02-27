class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // int min = Integer.MAX_VALUE;
        // for (int t : time) min = Math.min(min, t);
        // long low = 0, high = min * totalTrips;
        // while (low < high) {
        //     long mid = low + (high - low) / 2;
        //     long trips = 0;
        //     for (int t : time) {
        //         trips += mid / t;
        //     }
        //     if (trips < totalTrips) {
        //         low = mid + 1;
        //     } else {
        //         high = mid;
        //     }
        // }
        // return low;
        long lo = 0, hi = 100_000_000_000_000L;
        while (lo < hi) {
            long need = lo + (hi - lo) / 2;
            long trips = 0;
            for (int t : time) {
                trips += need / t;
            }
            if (trips < totalTrips) {
                lo = need + 1;
            }else {
                hi = need;
            }
        }
        return lo;
    }
}