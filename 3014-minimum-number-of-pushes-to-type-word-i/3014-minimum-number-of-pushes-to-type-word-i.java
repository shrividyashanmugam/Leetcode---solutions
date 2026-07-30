class Solution {
    public int minimumPushes(String word) {
        int sum = 0;
        int n = word.length();
        for(int i = 0;i<n;i++){
            sum += (i/8) + 1;
        }
    return sum;
    }
}