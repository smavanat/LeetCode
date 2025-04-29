//LeetCode Problem No.8: String to Integer
class StringToInteger {
    //Beats 100% in runtime and 81% in memory
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int result = 0, sign = 1;

        // Skip leading whitespaces (no need for s.trim())
        while (i < n && s.charAt(i) == ' ') i++;

        // Handle optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }


        // Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';

            // Check for overflow before multiplying.
            //Using same trick as for problem 7 with using raw values to reduce the memory value
            if (result > (2_147_483_647 - digit) / 10) {
                return sign == 1 ? 2_147_483_647 : -2_147_483_648;
            }

            result = result * 10 + digit;
        }

        return result * sign;
    }
}