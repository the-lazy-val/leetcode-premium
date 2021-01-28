/**
My solution: 5 ms
beats 100%

Keep an auxillary mxn matrix : max, similar to visited, but here store the already computed lengths
only process (x,y), if max[x][y] = 0

Also during processing (x,y), we have to check Math.max(top-Length, bottom-Length, left-Length, right-Length)
So, we check if the they are already processed, i.e. already in max[][]
In that case just do right = max[right-x][right-y] + 1

And dinally store max[x][y] = Math.max(left, right, top, bottom)
*/

class Solution {
    int[][] max;
    public void calculate(int[][] matrix, int[][] max, int x, int y, int m, int n){
            int curr = matrix[x][y];
        
            int left = 1;
            int right = 1;
            int top = 1;
            int bottom = 1;
        
            //bottom
            if(x+1 < m && matrix[x+1][y] > curr){
                if(max[x+1][y] > 0){
                    bottom += max[x+1][y];
                }else{
                    calculate(matrix, max, x+1, y, m, n);
                    bottom += max[x+1][y];
                }
            }
            //left
            if(y-1 >= 0 && matrix[x][y-1] > curr){
                if(max[x][y-1] > 0){
                    left += max[x][y-1];
                }else{
                    calculate(matrix, max, x, y-1, m, n);
                    left += max[x][y-1];
                }
            }
            //top
            if(x-1 >= 0 && matrix[x-1][y] > curr){
                if(max[x-1][y] > 0){
                    top += max[x-1][y];
                }else{
                    calculate(matrix, max, x-1, y, m, n);
                    top += max[x-1][y];
                }
            }
            //right
            if(y+1 < n && matrix[x][y+1] > curr){
                if(max[x][y+1] > 0){
                    right += max[x][y+1];
                }else{
                    calculate(matrix, max, x, y+1, m, n);
                    right += max[x][y+1];
                }
            }
        
        max[x][y] = Math.max(Math.max(left, right),Math.max(top, bottom));
        // System.out.println("("+x+","+y+") : "+max[x][y]);
        // System.out.println("left: "+left+" , right: "+right+" , top: "+top+" , bottom: "+bottom);
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        max = new int[m][n];
        
        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(max[x][y]==0){
                    calculate(matrix, max, x, y, m, n);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(max));
        
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(max[i][j] > res){
                    res = max[i][j];
                }
            }
        }
        
        return res;
    }
}
