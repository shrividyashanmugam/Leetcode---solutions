class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sumLeft = new int[n];
        int[] sumRight = new int[n];
        
        // Hint 1: Fill sumLeft array (moving forward)
        // sumLeft[0] is automatically 0
        for (int i = 1; i < n; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
        }
        
        // Hint 2: Fill sumRight array (moving backward)
        // sumRight[n-1] is automatically 0
        for (int i = n - 2; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + nums[i + 1];
        }
        
        // Hint 3: Compare both arrays for each index i
        for (int i = 0; i < n; i++) {
            if (sumLeft[i] == sumRight[i]) {
                return i; // Return the leftmost index immediately
            }
        }
        
        return -1;
    }
}
