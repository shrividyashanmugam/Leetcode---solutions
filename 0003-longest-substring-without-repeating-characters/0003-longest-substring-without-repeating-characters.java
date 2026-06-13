class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ASCII frequency array to store the last seen index + 1
        int[] lastSeen = new int[128]; 
        int maxLength = 0;
        
        // Sliding window defined by [left, right] pointers
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // Move left pointer rightwards if the character is already inside the window
            left = Math.max(left, lastSeen[ch]);
            // Calculate current substring length & update max
            maxLength = Math.max(maxLength, right - left + 1);
            // Mark the character as seen at the next index
            lastSeen[ch] = right + 1;
        }
        
        return maxLength;
    }
}