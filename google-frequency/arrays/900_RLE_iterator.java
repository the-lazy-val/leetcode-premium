/**
Insert elements of array in reverse in stack
 Now for each operation just update the top or pop
 
 */
 
 class RLEIterator {

    Stack<Pair<Integer, Integer>> st = new Stack<>();
    
    public RLEIterator(int[] A) {
        
        int len = A.length;
        
        for(int i=len-1; i>=0; i-=2){
            int count = A[i-1];
            int elem = A[i];
            
            if(count>0){
                st.push(new Pair(elem, count));
            }
        }
    }
    
    public int next(int n) {
        while(n>0 && !st.isEmpty()){
            Pair<Integer, Integer> top = st.pop();
            int count = top.getValue();
            if(count==n){
                n=0;
                return top.getKey();
            }else if(count > n){
                st.push(new Pair(top.getKey(), count-n));
                n=0;
                return top.getKey();
            }else{
                n-=count;
            }
        }
        
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
