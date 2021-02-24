class Solution {
    
    public void check(int[] arr, int start, int end){
        if(start>=end || start+1==end) return;
        
        int mid = start + (end-start)/2;
        
        check(arr, start, mid);
        check(arr, mid+1, end);
        
        if(arr[mid-1] + arr[mid+1] == 2*arr[mid]){//if condition fails then re-arrange
            
            int lengthBeforeMid = mid-start+1;
            int lengthAfterMid = end-mid;
            
            //copy array before mid to temp
            int[] tempStart = new int[lengthBeforeMid];
            System.arraycopy(arr, start, tempStart, 0, lengthBeforeMid);
            
            //copy after mid to start
            System.arraycopy(arr, mid+1, arr, start, lengthAfterMid);
            
            //copy temp after new mid
            int newMid = start+lengthAfterMid;
            System.arraycopy(tempStart, 0, arr, newMid, lengthBeforeMid);
        }
    }
    
    public int[] beautifulArray(int N) {
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        
        if(N==1 || N==2) return arr;
        
        check(arr, 0, N-1);
        return arr;
    }
}
