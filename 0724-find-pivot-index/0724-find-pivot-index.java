class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        for(int i =0;i< nums.length;i++){
                int rigthSum = totalSum - leftSum - nums[i];
                 

                 if(leftSum == rigthSum){
                    return i;
                 }
                 leftSum += nums[i];
        }
        return -1;
    }
}