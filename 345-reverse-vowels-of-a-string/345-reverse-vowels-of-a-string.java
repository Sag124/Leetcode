class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] char_arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !set.contains(char_arr[i])) {
                i++;
            }
            while (i < j && !set.contains(char_arr[j])) {
                j--;
            }
            char temp = char_arr[i];
            char_arr[i] = char_arr[j];
            char_arr[j] = temp;
            i++;
            j--;
        }
        
        return new String(char_arr);
    }
}