class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            if (!resMap.containsKey(map)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                resMap.put(map, list);
            } else {
                List<String> list = resMap.get(map);
                list.add(str);
                resMap.put(map, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (HashMap<Character, Integer> hm : resMap.keySet()) {
            List<String> list = resMap.get(hm);
            res.add(list);
        }
        return res;
    }
}