class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexes = new int[26];
        
        char[] str = S.toCharArray();
        
        for(int i=0; i<str.length; i++){
            lastIndexes[str[i] - 'a'] = i;
        }
        
        int i=0;
        
        List<Integer> output = new LinkedList();
        
        while(i < str.length){
            
            int end = lastIndexes[str[i] - 'a'];
            
            int j=i;
            while(j != end){
                end = Math.max(end, lastIndexes[str[j] - 'a']);
                j++;
            }
            
            output.add(j-i+1);
            i = j+1;
        }
        
        return output;
    }
}
