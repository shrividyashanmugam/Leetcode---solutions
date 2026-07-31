import java.util.*;

class Solution {
    private Map<String, List<String>> parents = new HashMap<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }

        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        dist.put(beginWord, 0);

        boolean found = false;
        int wordLen = beginWord.length();

        while (!queue.isEmpty() && !found) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String curr = queue.poll();
                int currentDist = dist.get(curr);
                char[] charArray = curr.toCharArray();

                for (int j = 0; j < wordLen; j++) {
                    char originalChar = charArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        charArray[j] = c;
                        String nextWord = new String(charArray);

                        if (dict.contains(nextWord)) {
                            if (!dist.containsKey(nextWord)) {
                                dist.put(nextWord, currentDist + 1);
                                parents.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(curr);
                                queue.offer(nextWord);
                                if (nextWord.equals(endWord)) {
                                    found = true;
                                }
                            } else if (dist.get(nextWord) == currentDist + 1) {
                                parents.get(nextWord).add(curr);
                            }
                        }
                    }
                    charArray[j] = originalChar;
                }
            }
        }

        if (dist.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, path);
        }

        return ans;
    }

    private void backtrack(String word, String beginWord, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> fullPath = new ArrayList<>(path);
            Collections.reverse(fullPath);
            ans.add(fullPath);
            return;
        }

        if (parents.containsKey(word)) {
            for (String parent : parents.get(word)) {
                path.add(parent);
                backtrack(parent, beginWord, path);
                path.remove(path.size() - 1);
            }
        }
    }
}