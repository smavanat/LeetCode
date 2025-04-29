//LeetCode Problem No.7 : Reverse Integer
class ReverInteger {
    //Beats 100% in runtime and 72.15% in memory
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            //Get the last digit of the original number
            int digit = x % 10;

            // Check for overflow before multiplying by 10 or adding digit
            //Using the pure number instead of Integer.MAX_VALUE/10 since this increases speed/memory
            if (reversed > 214748364 || 
                (reversed == 214748364 && digit > 7)) {
                return 0; // Overflow
            }
            if (reversed < -214748364 || 
                (reversed == -214748364 && digit < -8)) {
                return 0; // Underflow
            }

            //Add it on to the end of the reversed number
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        return reversed;
    }
}