/**
Binary Search + Array
*/

class Solution {
    
    public int getFrequency(String s){
        char[] str = s.toCharArray();
        int count=0;
        char curr = str[0];
        
        for(char c : str){
            if(c == curr){
               count++; 
            }
            if(c < curr){
                curr=c;
                count=1;
            }
        }
        
        return count;
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordcounts = new int[words.length];
        
        for(int i=0; i<words.length; i++){
            wordcounts[i] = getFrequency(words[i]);
        }
        
        //For BinarySearch approach
        Arrays.sort(wordcounts);
        int len=words.length;
        
        int[] result = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int currFreq = getFrequency(queries[i]);
            int curr=0;
            // for(int f : wordcounts){
            //     if(currFreq < f) curr++;
            // }
            
            //Optimized approach is to do binary search on wordcounts (sorted)
            int l=0;
            int r=len-1;
            boolean flag=true;
            
            while(l<=r && flag){
                int mid = (l+r)/2;
                
                if(wordcounts[mid] <= currFreq){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            
            result[i]= wordcounts.length - l;
        }
        
        return result;
    }
}
