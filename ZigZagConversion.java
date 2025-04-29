//LeetCode Problem No.6: ZigZag Conversion
public class ZigZagConversion {
    //Beats 100% in processing and 89% in memory
    public String convert(String s, int numRows) {
        //Early exit
        if(numRows>= s.length() || numRows == 1) {
            return s;
        }

        //Using a stringbuilder to store the new rows so that we can build the string quickly and easily
        StringBuilder result = new StringBuilder();
        //The amount of characters we need to skip to get the next character for
        //the current row
        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            //Getting the character in the same column by skipping the required amount of characters
            for (int j = row; j < s.length(); j += cycleLen) {
                result.append(s.charAt(j));

                // Middle rows have a second character in the same cycle
                int second = j + cycleLen - 2 * row;
                if (row != 0 && row != numRows - 1 && second < s.length()) {
                    result.append(s.charAt(second));
                }
            }
        }
        return result.toString();
    }
}
