class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> gmap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (gmap.containsKey(map)) {
                List<String> res = gmap.get(map);
                res.add(str);
                gmap.put(map, res);
            } else {
                List<String> res = new ArrayList<>();
                res.add(str);
                gmap.put(map, res);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> map : gmap.keySet()) {
            List<String> res = gmap.get(map);
            result.add(res);
        }
        return result;
    }
}