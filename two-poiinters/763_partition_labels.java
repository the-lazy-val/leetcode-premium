//Used merge intervals with LinkedList last
//currect anser but slow 6 ms, beats 31%

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, int[]> charRange = new HashMap();
        
        char[] str = S.toCharArray();
        
        for(int i=0; i<str.length; i++){
            char ch = str[i];
            if(charRange.containsKey(ch)){
                charRange.get(ch)[1] = i;
            }else{
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = i;
                charRange.put(ch, temp);
            }
        }
        
        ArrayList<int[]> ranges = new ArrayList(charRange.values());
        
        Collections.sort(ranges, (int[] a, int[] b) -> a[0] - b[0]);
        
        LinkedList<int[]> merged = new LinkedList();
        
        for(int[] range : ranges){
            
            if(merged.isEmpty()){
                merged.addLast(range);
            }else{
                int[] mergedLast = merged.getLast();
                
                int lastLeft = mergedLast[0];
                int lastRight = mergedLast[1];
                
                int currLeft = range[0];
                int currRight = range[1];
                
                if(currLeft > lastRight && currRight > lastRight){
                    
                    merged.addLast(range);
                    
                }else{
                    merged.removeLast();
                    int mergedRight = (lastRight > currRight) ? lastRight : currRight;
                    merged.addLast(new int[]{lastLeft, mergedRight});
                }
            }
            
        }
        
        LinkedList<Integer> output = new LinkedList();
        
        for(int[] range : merged){
            output.add(range[1] - range[0] + 1);
        }
        
        return output;
    }
}
