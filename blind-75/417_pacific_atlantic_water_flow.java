class Solution {
    
    public void dfs(int[][] height, boolean[][] visited, int x, int y, int r, int c){
        
        if(x<0 || x>=r || y<0 || y>=c) return;
        
        if(visited[x][y]) return; //already processed
        
        visited[x][y] = true;
        
        /**
        Since we are invoking dfs from the points where we are near the ocean
        We will check in all four directions, where height is greater,
        because then only water from a greater height can flow to this point (which is already connected to ocean)
        */
        
        //top
        if(x-1>=0 && height[x-1][y] >= height[x][y]){
            dfs(height, visited, x-1, y, r, c);
        }
        
        //right
        if(y+1<c && height[x][y+1] >= height[x][y]){
            dfs(height, visited, x, y+1, r, c);
        }
        
        //bottom
        if(x+1<r && height[x+1][y] >= height[x][y]){
            dfs(height, visited, x+1, y, r, c);
        }
        
        //left
        if(y-1>=0 && height[x][y-1] >= height[x][y]){
            dfs(height, visited, x, y-1, r, c);
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        if(matrix.length==0) return new ArrayList<>();
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        
        for(int i=0; i<r; i++){
            dfs(matrix, pacific, i, 0, r, c);
            dfs(matrix, atlantic, i, c-1, r, c);
        }
        
        for(int i=0; i<c; i++){
            dfs(matrix, pacific, 0, i, r, c);
            dfs(matrix, atlantic, r-1, i, r, c);
        }
        
        for(int x=0; x<r; x++){
            for(int y=0; y<c; y++){
                if(atlantic[x][y] && pacific[x][y]){
                    res.add(new ArrayList(Arrays.asList(x, y)));
                }
            }
        }
        
        return res;
    }
}
