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
