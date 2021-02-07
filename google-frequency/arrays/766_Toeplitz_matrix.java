class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int r=matrix.length;
        int c=matrix[0].length;
        
        for(int k=c-1; k>=0; k--){
            int x=0;
            int y=k;
            while(y+1<c && x+1<r){
                if(matrix[x][y] != matrix[x+1][y+1]){
                    return false;
                }
                x=x+1;
                y=y+1;
            }
        }
        
        for(int k=1; k<r; k++){
            int x=k;
            int y=0;
            
            while(y+1<c && x+1<r){
                if(matrix[x][y] != matrix[x+1][y+1]){
                    return false;
                }
                x=x+1;
                y=y+1;
            }
        }
        
        return true;
    }
}
