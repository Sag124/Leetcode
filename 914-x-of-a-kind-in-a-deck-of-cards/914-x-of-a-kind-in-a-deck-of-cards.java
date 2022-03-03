class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
       HashMap<Integer, Integer> map = new HashMap<>();
       
       for (int d : deck) {
           map.put(d, map.getOrDefault(d, 0) + 1);
       }
               
       int gcd = 0;
       for (int k : map.keySet()) {
           gcd = GCD(gcd, map.get(k));
           
       }
        if (gcd == 1) return false;
        else {
        return true;    
        }
        
    }
    
    public int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
    
}