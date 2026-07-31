class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        result[0] = findBound(nums, target, true);   // Find first position
        if (result[0] == -1) {
            return result; // Target doesn't exist in array
        }
        
        result[1] = findBound(nums, target, false);  // Find last position
        return result;
    }
    
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1; // Keep searching left to find first occurrence
                } else {
                    left = mid + 1;  // Keep searching right to find last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return bound;
    }
}