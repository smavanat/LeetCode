//LeetCode Problem No.11: Container with most water
class ContainerWithMostWater {
    //Beats 96% in processing and 65% in memory
    public int maxArea(int[] height) {
        int maxArea = 0; //Current max ares
        int i = 0; //left pointer
        int j = height.length-1; //right pointer

        //Keep going while the pointers have not overlapped to check all possible container heights
        while(i < j) {
            //Update the maxArea and move the smaller pointer
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i++]);
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j--]);
            }
        } 

        return maxArea;
    }
}