//LeetCode Problem No.14: Longest Common Prefix
class LongestCommonPrefix {
    //Beats 100% in processing and 64% in memory
    public String longestCommonPrefix(String[] strs) {
        //Create a stringbuilder as this will make it much easier to modify the string and set it
        //to the first string in the list
        StringBuilder prefix = new StringBuilder(strs[0]);
        //Can skip the first element in the list
        for(int i = 1; i < strs.length; i++) {
            //Compare if the prefixes are the same, and if not, keep deleting characters until they are
            while(!strs[i].startsWith(prefix.toString())){
                prefix.deleteCharAt(prefix.length()-1);
                //If the prefix is empty, return an empty string
                if(prefix.length()==0) return "";
            }
        }
        return prefix.toString();
    }
}