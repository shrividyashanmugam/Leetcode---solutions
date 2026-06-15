class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int num : nums){
            leftSum += num;
        }
        int[] array = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            leftSum -= nums[i];

            array[i] = Math.abs(leftSum - rightSum);

            rightSum += nums[i];
        }
        return array;
    }
}