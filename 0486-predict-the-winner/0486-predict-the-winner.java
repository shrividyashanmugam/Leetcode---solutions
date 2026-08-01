class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j] stores the maximum net score difference (current player's score - opponent's score)
        // for the subarray nums[i...j].
        int[][] dp = new int[n][n];

        // Base case: Subarray of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill the DP table for subarray lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // If player takes nums[i], opponent gets dp[i+1][j], net score difference = nums[i] - dp[i+1][j]
                // If player takes nums[j], opponent gets dp[i][j-1], net score difference = nums[j] - dp[i][j-1]
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // If net score difference for the entire array >= 0, Player 1 wins or ties.
        return dp[0][n - 1] >= 0;
    }
}