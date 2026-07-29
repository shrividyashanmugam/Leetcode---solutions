import java.util.Arrays;

class Solution {
    private static final int MAX_K = 1_000_001; // Capped at k_max + 1

    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] halfCount = new int[26];
        char midLetter = '\0';
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            halfLen += halfCount[i];
            if (count[i] % 2 == 1) {
                midLetter = (char) ('a' + i);
            }
        }

        // Check if there are at least k distinct palindromic permutations
        if (countArrangements(halfCount) < k) {
            return "";
        }

        StringBuilder leftHalf = new StringBuilder();

        // Construct the left half character by character
        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) continue;

                // Try picking character 'a' + i
                halfCount[i]--;
                int arrangements = countArrangements(halfCount);

                if (arrangements >= k) {
                    leftHalf.append((char) ('a' + i));
                    break; // Lock in this character
                } else {
                    k -= arrangements;
                    halfCount[i]++; // Backtrack and try next character
                }
            }
        }

        String left = leftHalf.toString();
        StringBuilder result = new StringBuilder(left);
        if (midLetter != '\0') {
            result.append(midLetter);
        }
        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }

    // Calculates total permutations of remaining character counts (multinomial coefficient)
    private int countArrangements(int[] count) {
        int total = 0;
        for (int c : count) {
            total += c;
        }

        long res = 1;
        for (int freq : count) {
            if (freq == 0) continue;
            res *= nCk(total, freq);
            if (res >= MAX_K) return MAX_K;
            total -= freq;
        }

        return (int) Math.min(res, MAX_K);
    }

    // Calculates combinations n Choose k capped at MAX_K
    private long nCk(int n, int k) {
        if (k < 0 || k > n) return 0;
        k = Math.min(k, n - k);

        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }
}