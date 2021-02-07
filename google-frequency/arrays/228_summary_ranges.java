class Solution {
    
    public void addRange(ArrayList<String> li, int start, int end){
        if(start==end) li.add(Integer.toString(start));
        else{
            li.add(start+"->"+end);
        }
    }
    
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        int i=0;
        
        ArrayList<String> li = new ArrayList();
        
        while(i<len){
            int start=nums[i];
            int end=start;
            
            while(i+1<len && end+1==nums[i+1]){
                end++;
                i++;
            }
            i++;
            addRange(li, start, end);
        }
        
        return li;
    }
}
