class Solution {
    
    public int getLongest(char[] s, int start, int end, int k){
        if(end-start+1 < k) return 0;
        
        int[] charCount = new int[26];
        for(int i=start; i<=end; i++){
            charCount[s[i]-'a']++;
        }
        
        for(int mid = start; mid<=end; mid++){
            if(charCount[s[mid] - 'a'] < k){
                return Math.max(getLongest(s, start, mid-1, k),  getLongest(s, mid+1, end, k));
            }
        }
        
        return (end-start+1);
    }
    
    public int longestSubstring(String s, int k) {
        return getLongest(s.toCharArray(), 0, s.length()-1, k);
    }
}
