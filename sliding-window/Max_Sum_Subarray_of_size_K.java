class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int max = Integer.MIN_VALUE;
        
        int sum=0;
        int count=0;
        
        int i=0;
        
        while(i<N){
            sum+=Arr.get(i);
            count++;
            
            if(count>K){
                count--;
                sum-= Arr.get(i-K);
            }
            
            max = Math.max(max, sum);
            i++;
        }
        
        return max;
    }
}
