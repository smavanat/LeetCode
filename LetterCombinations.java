import java.util.*;
//LeetCode Problem No. 17: Letter Combinations of a Phone Number
class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;//Empty string means empty array
        
        // Optimized: Using a 2D array for letter mapping
        char[][] letterMap = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        
        // Temporary StringBuilder reused for each combination
        StringBuilder comb = new StringBuilder();
        
        backtrack(digits, 0, comb, result, letterMap);
        
        return result;
    }

    //Helper recursive function
    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, char[][] letterMap) {
        //If we have passed the end of the string, just return the current combination since there's nothing left to add
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        //Get the characters associated with the current digit
        int digit = Character.getNumericValue(digits.charAt(idx)) - 2;
        char[] letters = letterMap[digit];
        
        //Add each letter to the end of the current combination
        for (char letter : letters) {
            comb.append(letter);  // Add the letter
            backtrack(digits, idx + 1, comb, res, letterMap);//Recursively keep adding letters
            comb.deleteCharAt(comb.length() - 1);  // Remove the letter so we can add the next one in the chain
        }
    }  
}