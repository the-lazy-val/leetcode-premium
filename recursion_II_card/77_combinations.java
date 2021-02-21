class Solution {
    
    List<List<Integer>> output = new LinkedList<>();
    
    public void getCombination(int n, int start, int k, LinkedList<Integer> res){
        if(k==0){
            // https://www.baeldung.com/java-copy-list-to-another
            LinkedList<Integer> temp = new LinkedList(res);//copying the list before adding to result
            
            output.add(temp);
            return;
        }
        
        for(int i=start; i<=n-k+1; i++){
            res.addLast(i);
            getCombination(n, i+1, k-1, res);
            res.removeLast();
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        getCombination(n, 1, k, new LinkedList());
        
        return output;
    }
}
