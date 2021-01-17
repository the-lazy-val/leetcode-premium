/**
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/

/**
My solution: already optimal

formula:

(0,1) -> (1,2)

(i, j) -> (j, (n-1-i))

new i = move j to i

new j = distance of i to n

*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        boolean[][] visited = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    
                    int a = i;
                    int b = j;
                    
                    int temp1 = matrix[a][b];
                    int temp2 = 0;
                    
                    int nexti = -1;
                    int nextj = -1;
                    
                    while(!visited[a][b]){
                        
                        visited[a][b] = true;
                        
                        nexti = b;
                        nextj = n-1-a;
                        
                        temp2 = matrix[nexti][nextj];
                        matrix[nexti][nextj] = temp1;
                        temp1 = temp2;
                        
                        a=nexti;
                        b=nextj;
                    }
                }
            }
        }
    }
}


// LC solution without extra space of visited matrix

class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2 + n % 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        int[] tmp = new int[4];
        int row = i;
        int col = j;
        for (int k = 0; k < 4; k++) {
          tmp[k] = matrix[row][col];
          int x = row;
          row = col;
          col = n - 1 - x;
        }
        for (int k = 0; k < 4; k++) {
          matrix[row][col] = tmp[(k + 3) % 4];
          int x = row;
          row = col;
          col = n - 1 - x;
        }
      }
    }
  }
}
