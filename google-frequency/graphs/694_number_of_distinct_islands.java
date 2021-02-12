class Solution {
    public void dfs(int[][] grid, int x, int y, int r, int c, StringBuilder sb){
        if(x<0 || x>=r || y<0 || y>=c || grid[x][y]==0) return;
        
        grid[x][y]=0;
        
        //top
        dfs(grid, x-1, y, r, c, sb.append('t'));
        
        //right
        dfs(grid, x, y+1, r, c, sb.append('r'));
        
        //bottom
        dfs(grid, x+1, y, r, c, sb.append('b'));
        
        //left
        dfs(grid, x, y-1, r, c, sb.append('l'));
    }
    
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> hs = new HashSet<>();
        
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==1){
                    
                    StringBuilder sb = new StringBuilder();
                    
                    dfs(grid, i, j, r, c, sb);
                    
                    hs.add(sb.toString());
                }
            }
        }
        
        return hs.size();
    }
}
