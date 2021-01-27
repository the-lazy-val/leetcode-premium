/**
My solution using DFS
1 ms
beats 100%



Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep
*/

class Solution {
    int count;
    boolean[][] visited;
    
    public void dfs(int x, int y, int m, int n, char[][] grid){
        if(!visited[x][y]){
            visited[x][y] = true;
        
            //left
            if(x+1 < m && grid[x+1][y] == '1'){
                dfs(x+1, y, m, n, grid);
            }
            //right
            if(y-1 >= 0 && grid[x][y-1] == '1'){
                dfs(x, y-1, m, n, grid);
            }
            //top
            if(x-1 >= 0 && grid[x-1][y] == '1'){
                dfs(x-1, y, m, n, grid);
            }
            //below
            if(y+1 < n && grid[x][y+1] == '1'){
                dfs(x, y+1, m, n, grid);
            }
            
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited = new boolean[m][n];
        count=0;
        
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(!visited[x][y] && grid[x][y]=='1'){
                    count++;
                    dfs(x,y,m,n,grid);
                }
            }
        }
        
        return count;
    }
}
