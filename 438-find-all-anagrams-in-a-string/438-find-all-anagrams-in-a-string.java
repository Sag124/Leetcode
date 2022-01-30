class Solution {
    
//     public boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {
//         for (Character sch : smap.keySet()) {
//             if (pmap.getOrDefault(sch, 0) != smap.get(sch)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
    private static boolean isAnagrams(int[] pfq, int[] sfq) {
		for (int i = 0; i < 26; i++) {
			if (pfq[i] != sfq[i]) {
				return false;
			}
		}
		return true;
	}
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return new ArrayList();
        }
        int[] pfq = new int[26];
		int[] sfq = new int[26];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i;
		for (i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			pfq[ch - 'a']++;
			sfq[s.charAt(i) - 'a']++;
		}
		if(isAnagrams(pfq, sfq)) {
			ans.add(0);
            res.add(0);
		}
		sfq[s.charAt(0) - 'a']--;
		int start = 1;
		for (; i < s.length(); i++) {
			char ch = s.charAt(i);
			sfq[ch - 'a']++;
			if(isAnagrams(pfq, sfq)) {
				ans.add(start);
                res.add(start);
			}
			sfq[s.charAt(start) - 'a']--;
			start++;
		}
		
        // System.out.println(ans.size());
        // for(int a : ans){
        //     System.out.print(a + " ");
        // }
        return res;
        
    }
}