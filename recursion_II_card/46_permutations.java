class Solution {
    
    List<List<Integer>> output = new LinkedList();
    
    public void generateCombos(int[] nums, int n, int k, LinkedList<Integer> res){
        if(k==0){
            output.add(new LinkedList(res));
            return;
        }
        
        for(int i=0; i<n; i++){
            
            int curr = nums[i];
            
            if(! res.contains(curr)){
                res.addLast(curr);
                generateCombos(nums, n, k-1, res);
                res.removeLast();
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        generateCombos(nums, n, n, new LinkedList());
        
        return output;
    }
}
