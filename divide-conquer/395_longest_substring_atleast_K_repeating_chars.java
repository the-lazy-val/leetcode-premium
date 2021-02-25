class Solution {
    
    public int getLongest(char[] s, int start, int end, int k){
        if(end-start+1 < k) return 0;
        
        int[] charCount = new int[26];//get char count of all chars in this window (start -> end)
        for(int i=start; i<=end; i++){
            charCount[s[i]-'a']++;
        }
        
        for(int mid = start; mid<=end; mid++){
            if(charCount[s[mid] - 'a'] < k){ //if any char has count < k, then this range (start -> end) cannot be valid max
                return Math.max(getLongest(s, start, mid-1, k),  getLongest(s, mid+1, end, k)); //so break into 2 from that index
            }
        }
        
        return (end-start+1);
    }
    
    public int longestSubstring(String s, int k) {
        return getLongest(s.toCharArray(), 0, s.length()-1, k);
    }
}
