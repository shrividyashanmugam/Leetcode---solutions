import java.util.Arrays;
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] counts = new int[maxVal + 1];
        for (int num : nums) {
            counts[num]++;
        }
        long[] gcdCounts = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            long totalMultiples = 0;
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                totalMultiples += counts[multiple];
            }
            long totalPairs = (totalMultiples * (totalMultiples - 1)) / 2;
            for (int multiple = 2 * g; multiple <= maxVal; multiple += g) {
                totalPairs -= gcdCounts[multiple];
            }

            gcdCounts[g] = totalPairs;
        }
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdCounts[i];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];
            int low = 1, high = maxVal, res = maxVal;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > targetIndex) {
                    res = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            answer[i] = res;
        }
        return answer;
    }
}