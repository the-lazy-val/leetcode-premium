/**
My solution

1 ms

beats 100%

DP + DFS
*/


class Solution {
    
    public boolean dfs(int[][] grid, int x, int y, int r, int c){
        if(grid[x][y] == 1) return true;
        if(x==0 || x==r-1 || y==0 || y==c-1) return false;
        
        grid[x][y] = 1;
        boolean top = dfs(grid, x-1, y, r, c);
        boolean right = dfs(grid, x, y+1, r, c);
        boolean bottom = dfs(grid, x+1, y, r, c);
        boolean left = dfs(grid, x, y-1, r, c);
        
        return top && right && bottom && left;
    }
    
    public int closedIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int count=0;
        
        for(int i=1; i<r-1; i++){
            for(int j=1; j<c-1; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j, r, c)) count++;
                }
            }
        }
        return count;
    }
}
