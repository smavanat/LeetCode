//LeetCode problem No.9 : Palindrome Number
class PalindromeNumber {
    //Beats 100% in processing and 95% in memory
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if(x < 0) return false;

        int reversed = 0; //The reverse of the int
        int xcopy = x; //A copy of the original int since we will be modifying x in the loop
        //While x still exists
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10); //Add another digit onto the end of the reverse
            x /= 10; //Remove a digit from x
        }

        return xcopy == reversed; 
    }
}