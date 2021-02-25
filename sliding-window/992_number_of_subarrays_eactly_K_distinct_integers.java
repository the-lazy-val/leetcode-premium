class Solution {
    
    // https://www.youtube.com/watch?v=CBSeilNvZHs
    
    public int subarraysAtmostKDistinct(int[] A, int K){
        int output=0;
        
        int i=0;
        int j=0;
        
        HashMap<Integer, Integer> hm = new HashMap();
        
        while(j<A.length){
            int num = A[j];
            hm.put(num, hm.getOrDefault(num, 0)+1);
            
            while(hm.size() > K){
                
                int rem = A[i];
                int remCount = hm.get(rem);
                
                if(remCount==1){
                    hm.remove(rem);
                }else{
                    hm.put(rem, remCount-1);
                }
                
                i++;
            }
            
            output += j-i+1;
            j++;
        }
        
        System.out.println("K: "+K+", count: "+output);
        
        return output;
    }
    
    public int subarraysWithKDistinct(int[] A, int K) {
        
        return subarraysAtmostKDistinct(A, K) - subarraysAtmostKDistinct(A, K-1);
    }
}
