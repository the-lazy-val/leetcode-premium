class Solution {
    
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList();
        q.add(start);
        
        int rows = maze.length;
        int cols = maze[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                
                if(x == destination[0] && y == destination[1]) return true;
                
                //top
                if(x-1>=0 && maze[x-1][y] == 0 && !visited[x-1][y]){
                    int temp = x;
                    while(temp-1>=0 && maze[temp-1][y] == 0){
                        // maze[temp-1][y] = 1;
                        temp--;
                    }
                    if(!visited[temp][y]){
                        visited[temp][y] = true;
                        q.add(new int[]{temp, y});
                    }
                }
                
                //left
                if(y+1 < cols && maze[x][y+1] == 0 && !visited[x][y+1]){
                    int temp = y;
                    while(temp+1<cols && maze[x][temp+1] == 0){
                        // maze[x][temp+1] = 1;
                        temp++;
                    }
                    if(!visited[x][temp]){
                        visited[x][temp] = true;
                        q.add(new int[]{x, temp});
                    }
                }
                
                //bottom
                if(x+1 < rows && maze[x+1][y] == 0 && !visited[x+1][y]){
                    int temp = x;
                    while(temp+1<rows && maze[temp+1][y] == 0){
                        // maze[temp+1][y] = 1;
                        temp++;
                    }
                    if(!visited[temp][y]){
                        visited[temp][y] = true;
                        q.add(new int[]{temp, y});
                    }
                }
                
                //right
                if(y-1>=0 && maze[x][y-1] == 0 && !visited[x][y-1]){
                    int temp = y;
                    while(temp-1>=0 && maze[x][temp-1] == 0){
                        // maze[x][temp-1] = 1;
                        temp--;
                    }
                    if(!visited[x][temp]){
                        visited[x][temp] = true;
                        q.add(new int[]{x, temp});
                    }
                }
                
                size--;
            }
        }
        
        return false;
        
    }
}
