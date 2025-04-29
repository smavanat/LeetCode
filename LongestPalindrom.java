//LeetCode problem No.5 : Longest Palindromic Substring
class LongestPalindrome {
    //Beats 99% performancewise and 60% memorywise
    //Use Manacher's Algorithm: https://medium.com/@kangjunong1/the-magic-of-manachers-algorithm-e37a85ddd94f
    public String longestPalindrome(String s) {
        //If the string is length 1 just return it.
        if(s.length() <= 1) {
            return s;
        }

        //Copy the string over to a char array to make it faster to manipulate
        int n = s.length();
        char[] t = new char[2 * n + 3];
        t[0] = '^';
        t[t.length - 1] = '$';
        //Alternate with placing '#' between each character to separate them
        for (int i = 0; i < n; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[2 * n + 1] = '#';

        //Array that tracks the radius of each palindrom
        int[] p = new int[t.length];
        int center = 0, right = 0; //The center of the rightmost palindrome found and its rightmost position
        int maxCenter = 0;//The center of the max length    palindrome

        for (int i = 1; i < t.length - 1; i++) {
            //Checking validity of radius
            if (i < right) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }

            //Increasing the size of the radius as long as the characters either side are palindromic
            while (t[i + p[i] + 1] == t[i - p[i] - 1]) {
                p[i]++;
            }

            //If we need to move the center
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            //If the current palindrome is longer than the maximum, reset the center of the longest palindrome
            if (p[i] > p[maxCenter]) {
                maxCenter = i;
            }
        }

        int start = (maxCenter - p[maxCenter]) / 2;
        return s.substring(start, start + p[maxCenter]);
    }
}