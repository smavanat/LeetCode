//Leetcode problem No.3: Length of Longest Substring
class LengthOfLongestSubstring {
    //Beats 99% speedwise and beats 94% memorywise
    public int lengthOfLongestSubstring(String s) {
        //There are only 128 unique ascii characters so they can be stored in an array
        int[] index = new int[128]; 
        int maxLength = 0; //The length of the longest substring
        int start = 0; //The start of the sliding window


        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            start = Math.max(index[currentChar], start);// Move start if repeated char found
            maxLength = Math.max(maxLength, i - start + 1);
            index[currentChar] = i + 1; // Store the next position (1-based to avoid zero-conflict)
        }

        return maxLength;
    }
}