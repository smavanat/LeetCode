//LeetCode Problem No. 12: Integer to Roman
class IntegerToRoman {
    //Beats 98.3% in runtime and 72% in memory
    public String intToRoman(int num) {
        //The significant numbers that we need to be aware of
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //The corresponding roman numeral string
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        //String builder to hold the final string
        StringBuilder sb = new StringBuilder();

        //Conversion loop by substracting the significant numbers from the given number, going
        //high to low
        for (int i = 0; i < nums.length && num > 0; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}