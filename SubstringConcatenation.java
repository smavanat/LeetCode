import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//LeetCode Problem No. 30: Substring with Concatenation of All Words
public class SubstringConcatenation {
    //Beats 97% in processing and 71% in memory
    public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> ans = new ArrayList<>();
        
        //Early exit
        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int N = s.length();

        //Populating the hashmap
        HashMap<String,Integer> originalCount = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
        }

        //Trying to find a concatenated substring. Since all words are of the same length, we can use this to determine the correct offset       
        for(int offset = 0; offset<wordSize; offset++){
            HashMap<String,Integer> currentCount = new HashMap<>();
            int start = offset; //Start position of the current substring
            int count = 0;
            //Skipping the first word, and skipping the possible next word, since all words are the same size
            for(int end = offset; end + wordSize <= N; end += wordSize){
                //Checking that the current subtring of length wordSize is a word
                String currWord = s.substring(end, end + wordSize);
                //If it is, we can add increase the count in the hashmap
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    //Check if we have a substring of all of the words
                    while(currentCount.get(currWord)>originalCount.get(currWord)){
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;                        
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }
                    
                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }
        }
        return ans;
    }
}
