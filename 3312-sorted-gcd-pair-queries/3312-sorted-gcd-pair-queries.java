class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Count frequencies of each number
        long[] cnt = new long[maxVal + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        
        // Count how many elements are multiples of each i
        long[] multiples = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                multiples[i] += cnt[j];
            }
        }
        
        // Count pairs with exact GCD = i using backward Inclusion-Exclusion DP
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long pairs = (multiples[i] * (multiples[i] - 1)) / 2;
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= gcdCount[j];
            }
            gcdCount[i] = pairs;
        }
        
        // Compute prefix sums of GCD frequencies
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdCount[i];
        }
        
        // Answer each query using binary search
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long q = queries[k];
            ans[k] = upperBinarySearch(prefixSums, q);
        }
        
        return ans;
    }
    
    // Finds the first index where prefixSums[index] > target
    private int upperBinarySearch(long[] prefixSums, long target) {
        int low = 1;
        int high = prefixSums.length - 1;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                ans = mid;
                high = mid - 1; // Look for a smaller index
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}