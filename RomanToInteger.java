//LeetCode Problem No.13: Roman to Integer
class RomanToInteger {
    //Beats 100% in runtime and 92% in memort
    public int romanToInt(String s) {
        //Originally used a Map for this but using Map.get() constantly was not performant
        int[] values = new int[26]; // 'A' to 'Z'
        //Only holding values for the roman numeral symbols
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int retNum = 0;
        for(int i = 0; i < s.length(); i++) {
            //Getting the current value
            int curr = values[s.charAt(i) - 'A'];
            //Getting the next value
            int next = (i + 1 < s.length()) ? values[s.charAt(i + 1) - 'A'] : 0;
            
            if (curr < next) {
                retNum += next - curr;
                i++; // Skip next so we don't add it twice
            } else {
                retNum += curr;
            }
        }
        return retNum;
    }
}