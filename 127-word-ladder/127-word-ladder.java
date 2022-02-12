class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current_word = queue.poll();
                char[] chars = current_word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original_char = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (original_char == c) continue;
                        chars[j] = c;
                        String new_word = String.valueOf(chars);
                        if (new_word.equals(endWord)) return level + 1;
                        if (set.contains(new_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    
                    chars[j] = original_char;
                }
            }
            level++;
        }
        
        return 0;
        
        
    }
}