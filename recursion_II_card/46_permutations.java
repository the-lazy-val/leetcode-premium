class Solution {
    
    List<List<Integer>> output = new LinkedList();
    
    public void generateCombos(int[] nums, int n, int k, LinkedList<Integer> res, HashSet<Integer> visited){
        if(k==0){
            output.add(new LinkedList(res));
            return;
        }
        
        for(int i=0; i<n; i++){
            
            int curr = nums[i];
            
            if(! visited.contains(curr)){
                res.addLast(curr);
                visited.add(curr);
                generateCombos(nums, n, k-1, res, visited);
                res.removeLast();
                visited.remove(curr);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        generateCombos(nums, n, n, new LinkedList(), new HashSet());
        
        return output;
    }
}
