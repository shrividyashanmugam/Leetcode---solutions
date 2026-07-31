class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            
            columnNumber /= 26;
        }
        
        return sb.reverse().toString();
    }
}