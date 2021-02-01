/**
2 ms
beats: 42%
This will work not just for alphabets but for UNICODE as well
*/

class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        
        LinkedList<int[]> output = new LinkedList<>();
        
        int[] last;
        
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        
        int len = intervals.length;
        int i = 0;
        
        for(i=0; i<len; i++){
            
            int[] slot = intervals[i];
            
            if(slot[0] <= newIntervalStart){
                output.add(slot);
            }else{
                break;
            }
        }
        
        
        if(output.isEmpty()){
            output.add(newInterval);
        }else if(newInterval[0] <= output.getLast()[1]){
            last = output.getLast();
            output.removeLast();
            output.add(new int[]{Math.min(last[0],newInterval[0]), Math.max(last[1], newInterval[1])});
        }else{
            output.add(newInterval);
        }
        
        while(i<len){
            int[] slot = intervals[i];
            
            
            if(slot[0] <= newIntervalEnd){
                last = output.getLast();
                output.removeLast();
                output.add(new int[]{Math.min(last[0], slot[0]), Math.max(last[1], slot[1])});
            }else{
                output.add(slot);
            }
            
            i++;
        }
        
        return output.toArray(new int[output.size()][2]);
       
    }
}

/**
Faster: 1ms
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList();
        for(int[] in:intervals)
        {
            if(in[1]<newInterval[0])
            {
                result.add(in);
            }
            
            else if(newInterval[1]<in[0])
            {
                result.add(newInterval);
                newInterval=in;
            }
            else
            {
                newInterval[0]=Math.min(newInterval[0],in[0]);
               newInterval[1]=Math.max(newInterval[1],in[1]);
            }
            
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
        
    }
}

/**
Just alphabaet
*/

class Solution {
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        
        for(int c : count){
            if(c != 0) return false;
        }
        
        return true;
    }
}
