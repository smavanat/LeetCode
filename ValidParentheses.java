import java.util.Stack;
//LeetCode Problem No. 20: Valid Parentheses
public class ValidParentheses {
    //Beats 97% in processing and 92% in memory
    public boolean isValid(String s) {
        //Use a stack to store the most recent open brackets
        Stack<Character> openBrackets = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            //Switch cases, if its an open bracket, add it to the stack,
            //If its an empty bracket, check that the stack is not empty, and that the top
            //element is the equivalent open bracket, and pop if these conditions are satisfied
            switch (s.charAt(i)) {
                case '(':
                    openBrackets.push(s.charAt(i));
                    break;
                case '[':
                    openBrackets.push(s.charAt(i));
                    break;
                case '{':
                    openBrackets.push(s.charAt(i));
                    break;
                case ')':
                    if(!openBrackets.isEmpty() && openBrackets.peek() == '(') {
                        openBrackets.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                case ']':
                    if(!openBrackets.isEmpty() && openBrackets.peek() == '[') {
                        openBrackets.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                case '}':
                    if(!openBrackets.isEmpty() && openBrackets.peek() == '{') {
                        openBrackets.pop();
                    }
                    else {
                        return false;
                    }
                    break;
            }
        }
        return openBrackets.isEmpty();
    }
}
