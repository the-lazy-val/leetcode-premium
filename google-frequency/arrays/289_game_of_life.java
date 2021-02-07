//If we want to do in O(1) space then
//the trick is to denote :
// live --> die as -1 
//  die --> live as 2
// and include this as well in calculating neighbors

class Solution {
    
    public int getNeighbors(int x, int y, int r, int c, int[][] board){
        int count=0;
        
        if(x-1>=0 && y-1 >=0 && board[x-1][y-1]==1) count++;
        
        if(x-1>=0 && y+1 < c && board[x-1][y+1]==1) count++;
        
        if(x-1>=0 && board[x-1][y]==1) count++;
        
        if(y+1 < c && board[x][y+1]==1) count++;
        
        if(x+1<r  && y+1 < c && board[x+1][y+1]==1) count++;
        
        if(x+1<r && board[x+1][y]==1) count++;
        
        if(x+1<r && y-1>=0 && board[x+1][y-1]==1) count++;
        
        if(y-1>=0 && board[x][y-1]==1) count++;
        
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        
        int r = board.length;
        int c = board[0].length;
        
        int[][] next = new int[r][c];
        
        for(int x=0; x<r; x++){
            for(int y=0; y<c; y++){
                int nbrs = getNeighbors(x, y, r, c, board);
                int curr = board[x][y];
                
                if(curr==1){
                    if(nbrs < 2) next[x][y]=0;
                    else if (nbrs > 3) next[x][y]=0;
                    else next[x][y]=1;
                }else{
                    if(nbrs==3) next[x][y]=1;
                }
            }
        }
        
        for(int i=0; i<r; i++){
            board[i] = Arrays.copyOf(next[i], c);
        }
    }
}


/**
For Infinite Board

https://leetcode.com/problems/game-of-life/discuss/73217/Infinite-board-solution/76083
*/

    private Set<Coord> gameOfLife(Set<Coord> live) {
        Map<Coord,Integer> neighbours = new HashMap<>();
        for (Coord cell : live) {
            for (int i = cell.i-1; i<cell.i+2; i++) {
                for (int j = cell.j-1; j<cell.j+2; j++) {
                    if (i==cell.i && j==cell.j) continue;
                    Coord c = new Coord(i,j);
                    if (neighbours.containsKey(c)) {
                        neighbours.put(c, neighbours.get(c) + 1);
                    } else {
                        neighbours.put(c, 1);
                    }
                }
            }
        }
        Set<Coord> newLive = new HashSet<>();
        for (Map.Entry<Coord,Integer> cell : neighbours.entrySet())  {
            if (cell.getValue() == 3 || cell.getValue() == 2 && live.contains(cell.getKey())) {
                newLive.add(cell.getKey());
            }
        }
        return newLive;
    }

//where Coord is:

    private static class Coord {
        int i;
        int j;
        private Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public boolean equals(Object o) {
            return o instanceof Coord && ((Coord)o).i == i && ((Coord)o).j == j;
        }
        public int hashCode() {
            int hashCode = 1;
            hashCode = 31 * hashCode + i;
            hashCode = 31 * hashCode + j;
            return hashCode;
        }
    }

//and the wrapper:

    public void gameOfLife(int[][] board) {
        Set<Coord> live = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == 1) {
                    live.add(new Coord(i,j));
                }
            }
        };
        live = gameOfLife(live);
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                board[i][j] = live.contains(new Coord(i,j))?1:0;
            }
        };
        
    }
