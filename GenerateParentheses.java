import java.util.ArrayList;
import java.util.List;
//LeetCode Problem No. 22: Generate Parentheses
public class GenerateParentheses {
    //Beats 100% in processing and 89% in memory
    public List<String> generateParenthesis(int n) {
        if(n < 1) return new ArrayList<String>();//Early return if invalid input

        ArrayList<String> combinations = new ArrayList<String>();//Where our string operations go
        recursiveOperations(0, 0, n, new StringBuilder(), combinations); //Calling the recursive method to get our strings
        return combinations;
    }

    //A recursive function that finds all the bracket combinations
    private void recursiveOperations(int numOpen, int numClosed, int n, StringBuilder sb, ArrayList<String> combs) {
        //If the number of open and closed brackets is the same as the number of brackets that should be 
        //in the string, return the string
        if(numOpen == numClosed && numOpen + numClosed == n*2) {
            combs.add(sb.toString());
            return;
        }

        //If the number of open brackets has not reached n yet, add an extra bracket on and continue on recursively
        if(numOpen < n) {
            sb.append("(");
            recursiveOperations(numOpen+1, numClosed, n, sb, combs);
            sb.deleteCharAt(sb.length()-1); //Remove the open bracket so that the next check is unaffected
        }

        //If the number of closed is less than the number of open brackets, add a closed bracket, and continue recursively
        if(numClosed < numOpen) {
            sb.append(")");
            recursiveOperations(numOpen, numClosed+1, n, sb, combs);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}