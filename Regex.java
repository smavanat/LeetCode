//LeetCode Problem No. 10: Regular Expression Matching
public class Regex {
    //Beats 100% in processing and 94% in memory
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(); //Getting the length of the two strings
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];

        prev[0] = true;

        // Initialize patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && prev[j - 2]) {
                prev[j] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = false;
            for (int j = 1; j <= n; j++) {
                //Getting the string and pattern chars
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    curr[j] = prev[j - 1]; //Matching for '.'
                } else if (pc == '*') {
                    curr[j] = curr[j - 2];// Treat '*' as matching zero of previous
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) {
                        curr[j] |= prev[j]; // '*' matches one or more of prev
                    }
                } else {
                    curr[j] = false;
                }
            }
            // Swap rows
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
