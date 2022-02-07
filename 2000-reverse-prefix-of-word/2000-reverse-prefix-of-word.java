class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index == -1) return word;
        String first = word.substring(0, index+1);
        StringBuilder sb = new StringBuilder(first);
        first = sb.reverse().toString();
        String second = word.substring(index+1);
        return first+second;
    }
}