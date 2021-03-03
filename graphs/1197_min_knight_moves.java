class Solution {
    
    int[][] dir = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2, -1}, {1,-2}, {-1,-2}, {-2, -1}};
    
    public int minKnightMoves(int x, int y) {
        if(x==0 && y==0) return 0;
        
        int[] start = new int[]{0, 0};
        
        Queue<int[]> q = new LinkedList();
        q.add(start);
        
        // HashSet<int[]> visited = new HashSet();
        // visited.add(start);
        
        HashSet<String> visited = new HashSet();
        visited.add("0,0");
        
        int distance = -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            distance++;
            while(size > 0){
                int[] curr = q.poll();
                
                int X = curr[0];
                int Y = curr[1];
                
                if(X == Math.abs(x) && Y == Math.abs(y)) return distance;
                
                for(int i=0; i<8; i++){
                    
                    int newX = X+dir[i][0];
                    int newY = Y+dir[i][1];
                    
                    /**
                    int[] nghbr = new int[]{newX, newY};
                    Arrays in Java are objects and don't override hashCode and equals. To better understand this, take the example below:

                    Set<int[]> set = new HashSet<>();

                    set.add(new int[] {1, 2});
                    set.add(new int[] {3, 4});

                    System.out.println(set.contains(new int[] {1, 2})); // false

                    */
                    
                    /**
                    Investigate 2 optimizations:
                    - Bi-directional BFS
                    - symmetry around grid quadrants
                    */
                    
                    String nghbr = newX+","+newY;
                    
                    if(! visited.contains(nghbr) && newX>=-1 && newY>=-1){
                        visited.add(nghbr);
                        q.add(new int[]{newX, newY});
                    }
                }
                
                size--;
            }
        }
        
        return -1;
    }
}
