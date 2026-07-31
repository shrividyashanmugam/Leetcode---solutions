class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 1; i < n; i++) {
            s = getNext(s);
        }
        
        return s;
    }
    
    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // If the next character is the same, increment count
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                // Otherwise, append the count and character, then reset count
                sb.append(count).append(s.charAt(i));
                count = 1;
            }
        }
        
        return sb.toString();
    }
}