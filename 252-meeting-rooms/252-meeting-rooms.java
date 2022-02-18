class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int[] prev = list.get(list.size() - 1);
                if (interval[0] < prev[1]) {
                    prev[1] = Math.max(prev[1], interval[1]);
                    return false;
                } else {
                    list.add(interval);
                }
            }
        }
        
        return true;
    }
}