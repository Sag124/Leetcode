class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        int matchCount = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
            matchCount++;
        }
        HashMap<Character, Integer> smap = new HashMap<>();
       
        
        int i = -1;
        int j = -1;
        int mct = 0;
        int dmct = t.length();
        String ans = "";
        
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            
            // acquire
            while (i < s.length() - 1 && mct < dmct) {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
                if (smap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0)) {
                    mct++;
                }
            }
            
            // release
            while (j < i && mct == dmct) {
                f2 = true;
                String pans = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                } 
                j++;
                char ch = s.charAt(j);
                if (smap.get(ch) == 1) {
                    smap.remove(ch);
                } else {
                   smap.put(ch, smap.get(ch) - 1);
                }
                
                if (smap.getOrDefault(ch, 0) < tmap.getOrDefault(ch, 0)) {
                    mct--;
                }
                
            }
            
            if (f1 == false && f2 == false) {
                break;
            }
            
        }
        return ans;
        
    }
}