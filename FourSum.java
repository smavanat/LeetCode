import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//LeetCode Problem No. 18 : 4Sum
public class FourSum {
    //Beats 97% in processing and 79% in memory
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        //Essentially just do the outer loop for ThreeSum twice
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Skip if the minimum possible sum is already too large
            if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;

            // Skip if the maximum possible sum is too small
            if ((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                // Two pointers approach
                int left = j + 1;
                int right = n - 1;
                
                //Traversing the array to find two values that add up to -nums[i]
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    //Since the array is sorted, if the sum is too low, increase the right pointer
                    if (sum > target) {
                        right--;
                    //If the sum is too low, increase the left pointer
                    } else if (sum < target) {
                        left++;
                    //If the sum is just right, add the triplet to the returned list
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicates for left and right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}  
