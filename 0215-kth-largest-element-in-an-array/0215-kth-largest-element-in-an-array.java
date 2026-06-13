class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max=nums[0];int min=nums[0];
        for(int n:nums){
            if(n>max)
            max=n;
            else if(n<min)
            min=n;
        }
        int[]freq=new int[max-min+1];
        for(int n:nums){
        freq[n-min]++;  
    }
    for(int i=freq.length-1;;i--){
        k-=freq[i];
        if(k<=0)
        return i+min;
      }
 } 
}