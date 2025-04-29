import java.util.*;
//LeetCode Problem No. 15: 3Sum
class ThreeSum {
    //Beats 99.6% in processing and 93% in memory
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array
        Arrays.sort(nums);
        
        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            //Since the array is sorted, if the value at the current index is > 0, there can be no non-duplicate triplet pairs left in the array that sum to 0 using this value
            if(nums[i] > 0) break;
            
            // Two pointers approach
            int left = i + 1;
            int right = nums.length - 1;
            
            //Traversing the array to find two values that add up to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //Since the array is sorted, if the sum is too low, increase the right pointer
                if (sum > 0) {
                    right--;
                //If the sum is too low, increase the left pointer
                } else if (sum < 0) {
                    left++;
                //If the sum is just right, add the triplet to the returned list
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    while (nums[left] == nums[left-1] && left < right) {
                        left++;
                    }
                }
            }
        }
        
        return result;
    }
}