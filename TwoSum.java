import java.util.HashMap;
//Leetcode problem No.1: Two Sum
class TwoSum {
    //Beats 99% speedwise and 78% memorywise
    public int[] twoSum(int[] nums, int target) {
        //HashMap for efficient retrieval
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Traverse the array, checking if the HashMap contains its complement 
        //(the number which will allow it to add up to the target), and return if true
        //Otherwise add the number to the hashmap, with its array index as the value
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }

        //Throw an exception if there is no solution (but the test cases always guarantee one)
        throw new IllegalArgumentException("No two sum solution");
    }
}