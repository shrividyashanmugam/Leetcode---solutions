import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int level = 1;
        int wordLen = beginWord.length();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] chars = current.toCharArray();

                for (int j = 0; j < wordLen; j++) {
                    char originalChar = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (dict.contains(nextWord)) {
                            queue.offer(nextWord);
                            dict.remove(nextWord); // mark as visited
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }
}