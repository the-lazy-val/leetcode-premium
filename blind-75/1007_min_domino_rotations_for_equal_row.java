//  3ms beats 98%
// O(4*N)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[][] swaps = new int[][]{{A[0], 0}, {B[0], 1}, {A[0], 1}, {B[0], 0}};
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            int[] first = A;
            int[] second = B;
            boolean flag=true;
            
            if(i>1) {
                first = B;
                second = A;
            }
            
            int elem=swaps[i][0];
            int count=swaps[i][1];
            
            for(int j=1; j<first.length; j++){
                if(first[j]!=elem){
                    if(second[j]==elem){
                        count++;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                min = Math.min(count, min);
            }
        }
        
        if(min==Integer.MAX_VALUE) return -1; else return min;
    }
}
