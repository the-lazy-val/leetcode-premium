/**
My solution: 2ms
O(N)

similar approach to number of islands

beats 99.43%
*/

class Solution {
    
    public int getArea(int[][] grid, int x, int y, int r, int c){
        if(x<0 || y<0 || x>=r || y>=c){
            return 0;
        }
        else if(grid[x][y]==0){
            return 0;
        }else{
            int area = 1;
            grid[x][y] = 0;
            area+= getArea(grid, x, y-1, r, c) + getArea(grid, x-1, y, r, c) + getArea(grid, x, y+1, r, c) + getArea(grid, x+1, y, r, c);
            
            return area;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int max = 0;
        for(int x=0; x<r; x++){
            for(int y=0; y<c; y++){
                if(grid[x][y] == 1){
                    int temp = getArea(grid, x, y, r, c);
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }
}
