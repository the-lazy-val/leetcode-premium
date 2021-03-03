class Solution {
    
    // https://leetcode.com/problems/the-maze-ii/discuss/98392/Similar-to-The-Maze.-Easy-understanding-Java-bfs-solution.
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{start[0], start[1], 0});
        
        int rows = maze.length;
        int cols = maze[0].length;
        
        int[][] dpDistance = new int[rows][cols];
        for(int[] r : dpDistance){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int d = curr[2];
                
                //top
                if(x-1>=0 && maze[x-1][y] == 0){
                    int temp = x;
                    int len = d;
                    while(temp-1>=0 && maze[temp-1][y] == 0){
                        temp--;
                        len++;
                    }
                    
                    if(len < dpDistance[temp][y]){
                        dpDistance[temp][y] = len;
                        q.add(new int[]{temp, y, len});
                    }
                }
                
                //left
                if(y+1 < cols && maze[x][y+1] == 0){
                    int temp = y;
                    int len = d;
                    while(temp+1<cols && maze[x][temp+1] == 0){
                        temp++;
                        len++;
                    }
                    if(len < dpDistance[x][temp]){
                        dpDistance[x][temp] = len;
                        q.add(new int[]{x, temp, len});
                    }
                }
                
                //bottom
                if(x+1 < rows && maze[x+1][y] == 0){
                    int temp = x;
                    int len = d;
                    while(temp+1<rows && maze[temp+1][y] == 0){
                        temp++;
                        len++;
                    }
                    if(len < dpDistance[temp][y]){
                        dpDistance[temp][y] = len;
                        q.add(new int[]{temp, y, len});
                    }
                }
                
                //right
                if(y-1>=0 && maze[x][y-1] == 0){
                    int temp = y;
                    int len = d;
                    while(temp-1>=0 && maze[x][temp-1] == 0){
                        temp--;
                        len++;
                    }
                    if(len < dpDistance[x][temp]){
                        dpDistance[x][temp] = len;
                        q.add(new int[]{x, temp, len});
                    }
                }
                
                size--;
            }
        }
        
        return (dpDistance[destination[0]][destination[1]] == Integer.MAX_VALUE) ? -1 : dpDistance[destination[0]][destination[1]];
    }
}
