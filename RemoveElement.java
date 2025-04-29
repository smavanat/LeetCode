//LeetCode Problem No. 27: Remove Element
public class RemoveElement {
    //Beats 100% in processing and 67% in memory
    public int removeElement(int[] nums, int val) {
        int swapIndex = 0;//Holds the index of the element to be swapped with

        for (int i = 0; i < nums.length; i++) {
            //Swap all elements so that they are all located in the first k elements of the array
            if (nums[i] != val) {
                nums[swapIndex] = nums[i];
                swapIndex++;
            }
        }

        return swapIndex;  
    }
}
