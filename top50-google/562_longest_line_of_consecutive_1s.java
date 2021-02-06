/**
My Solution: O(N)
*/

class Solution {
    
    int[][] right;
    int[][] diag;
    int[][] bottom;
    int[][] antidiag;
    
    int max=0;
    
    public int longestLine(int[][] M) {
        int r = M.length;
        if(r==0) return 0;
        
        int c = M[0].length;
        
        right = new int[r][c];
        diag = new int[r][c];
        bottom = new int[r][c];
        antidiag = new int[r][c];
        
        for(int i=r-1; i>=0;  i--){
            for(int j=c-1; j>=0; j--){
                if(M[i][j]!=0){
                    
                    right[i][j] = 1;
                    diag[i][j] = 1;
                    bottom[i][j] = 1;
                    antidiag[i][j] = 1;
                    
                    
                    if(j+1 < c){
                        right[i][j] += right[i][j+1];
                    }
                    
                    if(i+1 < r && j+1 < c){
                        diag[i][j] += diag[i+1][j+1];
                    }
                    
                    if(i+1 < r){
                        bottom[i][j] += bottom[i+1][j];
                    }
                    
                    if(i+1<r && j-1>=0){
                        antidiag[i][j] += antidiag[i+1][j-1];
                    }
                    
                    int localMax = Math.max(Math.max(right[i][j], diag[i][j]), Math.max(bottom[i][j], antidiag[i][j]));
                    max = Math.max(max, localMax);
                }
            }
        }
        
        return max;
    }
}
