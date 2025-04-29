//LeetCode Problem No. 26: Remove Duplicates from sorted array
public class RemoveDuplicates {
    //Beats 100% in processing and 63% in memory
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0; //Early exit condition
        int index = 1; //Tracks the index of where we need to put the current unique number
        
        for(int i = 1; i < nums.length; i++) {
            //If the number is unique, add it at the current unique index and increment
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
