//DFS approach: TLE
// 26/39 tests passed

class Solution {
    
    public int dfs(int[][] grid, int x, int y, int currHeight, int r, int c, boolean[][] visited){
        if(x==0 || x==r-1 || y==0 || y==c-1) return 0;
        
        int min = Integer.MAX_VALUE;
        
        visited[x][y] = true;
        
        //left
        if(!visited[x][y-1]){
            if(grid[x][y-1] > currHeight){
                min = Math.min(min, Math.max(grid[x][y-1], dfs(grid, x, y-1, currHeight, r, c, visited)));
            }else{
                min = Math.min(min, dfs(grid, x, y-1, currHeight, r, c, visited));
            }
        }
        
        
        
        //top
        if(!visited[x-1][y]){
        if(grid[x-1][y] > currHeight){
            min = Math.min(min, Math.max(grid[x-1][y], dfs(grid, x-1, y, currHeight, r, c, visited)));
        }else{
            min = Math.min(min, dfs(grid, x-1, y, currHeight, r, c, visited));
        }
        }
        
        
        //right
        if(!visited[x][y+1]){
        if(grid[x][y+1] > currHeight){
             min = Math.min(min, Math.max(grid[x][y+1], dfs(grid, x, y+1, currHeight, r, c, visited)));
        }else{
            min = Math.min(min, dfs(grid, x, y+1, currHeight, r, c, visited));
        }
        }
        
        
        //bottom
        if(!visited[x+1][y]){
        if(grid[x+1][y] > currHeight){
            min = Math.min(min, Math.max(grid[x+1][y], dfs(grid, x+1, y, currHeight, r, c, visited)));
        }else{
            min = Math.min(min, dfs(grid, x+1, y, currHeight, r, c, visited));
        }
        }
        
        visited[x][y] = false;
        
        return min;
    }
    
    public int trapRainWater(int[][] heightMap) {
        
        int r = heightMap.length;
        int c = heightMap[0].length;
        
        if(r<=2 || c<=2) return 0;
        
        boolean[][] visited = new boolean[r][c];
        
        int total=0;
        
        for(int x=1; x<r-1; x++){
            for(int y=1; y<c-1; y++){
                int currHeight = heightMap[x][y];
                int minOfMax = dfs(heightMap, x, y, currHeight, r, c, visited);
                
                if(minOfMax>currHeight){
                    total += minOfMax-currHeight;
                }
            }
        }
        
        return total;
    }
}
