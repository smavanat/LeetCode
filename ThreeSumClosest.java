import java.util.Arrays;;
//LeetCode Problem 16: Three Sum Closest
class ThreeSumClosest {
    //Beats 85% in processing and 89% in memory
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE/2; //An arbitrarily high value for the closest sum
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {  
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two pointers approach
            int left = i + 1;
            int right = nums.length - 1;
            
            //Traversing the array to find two values that add up to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //Update the closest sum value
                if(Math.abs(sum-target) < Math.abs(closestSum-target)){
                    closestSum = sum;
                }
                //Since the array is sorted, if the sum is too low, increase the right pointer
                if (sum > target) {
                    right--;
                //If the sum is too low, increase the left pointer
                } else if (sum < target) {
                    left++;
                //If the sum is just right, return it
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}