class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        
        int time = -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int freshOrangeCount = 0; //to check if all freshOranges were covered in the BFS
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    freshOrangeCount++;
                }
            }
        }
        
        if(freshOrangeCount==0) return 0; //since there were no fresh oranges
        
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            
            while(size > 0){
                
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                
                //top
                if(x-1>=0 && grid[x-1][y]==1){
                    freshOrangeCount--;
                    grid[x-1][y] = 2; //equivalent to visited
                    q.add(new int[]{x-1, y});
                }
                
                //right
                if(y+1<cols && grid[x][y+1]==1){
                    freshOrangeCount--;
                    grid[x][y+1] = 2;
                    q.add(new int[]{x, y+1});
                }
                
                //bottom
                if(x+1<rows && grid[x+1][y]==1){
                    freshOrangeCount--;
                    grid[x+1][y] = 2;
                    q.add(new int[]{x+1, y});
                }
                
                //left
                if(y-1>=0 && grid[x][y-1]==1){
                    freshOrangeCount--;
                    grid[x][y-1] = 2;
                    q.add(new int[]{x, y-1});
                }
                
                size--;
            } 
        }
        
        return (freshOrangeCount > 0) ? -1 : time;
    }
}
