class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            int gs = key + 1;
            int val = map.get(key);
            count += Math.ceil(val * 1.0/gs) * gs;
        }
        return count;
    }
}

/*
1 - 2
2 - 1

gs  = 2
val = 2
2 * (2/2) + 


gs = 3
val = 1
2 + 3 * (1/3)

*/
