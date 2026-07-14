import java.util.*;

class Solution {
    private List<List<Integer>> finalResult;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                f();
                return finalResult.get(index);
            }

            public int size() {
                f();
                return finalResult.size();
            }

            private void f() { 
                List<List<Integer>> resultList = new ArrayList<>();
                Set<List<Integer>> uniqueSet = new HashSet<>();
                int n = nums.length;
                Arrays.sort(nums);
                for(int first = 0; first < n - 3; first++) {
                    for(int second = first + 1; second < n - 2; second++) {
                        long remainingTarget = (long) target - (long) nums[first] - (long) nums[second];
                        int left = second + 1, right = n - 1;

                        while(left < right) {
                            if(nums[left] + nums[right] == remainingTarget) {
                                uniqueSet.add(Arrays.asList(nums[left], nums[right], nums[first], nums[second]));
                                while(left < right && nums[left] == nums[left + 1]) 
                                    left++;
                                while(left < right && nums[right] == nums[right - 1]) 
                                    right--;
                                left++;
                                right--;
                            } else if(nums[left] + nums[right] < remainingTarget) {
                                left++;
                            } else {
                                right--;
                            }
                        }
                    }
                }
                resultList.addAll(uniqueSet);
                finalResult = resultList;
            }
        };
    }
}