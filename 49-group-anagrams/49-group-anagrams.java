class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> gmap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (gmap.containsKey(map)) {
                List<String> list = gmap.get(map);
                list.add(str);
                gmap.put(map, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                gmap.put(map, list);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (HashMap<Character, Integer> map : gmap.keySet()) {
            List<String> li = gmap.get(map);
            res.add(li);
        }
        return res;
    }
}