//LeetCode Problem No. 28: Find the Index of the First Occurrence in a String
public class FindIndex {
    //Beats 100% in processing and 78% in memory
    public int strStr(String haystack, String needle) {
        //Since this is considered an "easy" problem, can just use a library function. 
        //Otherwise you would use KMP
        return haystack.indexOf(needle);
    }
}
