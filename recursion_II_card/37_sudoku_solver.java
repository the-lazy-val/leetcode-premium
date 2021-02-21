class Solution {
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3;
        int blkcol = (col / 3) * 3; // Block no. is row/3, first element is col/3*3
        
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || 
                board[row][i] == num || 
                board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
    
    public boolean backtrack(char[][] board){
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    
                    for(char v='1'; v<='9'; v++){ //choices
                        
                        if(isValid(board, i, j, v)){ //constraint
                            board[i][j] = v;
                            
                            if(backtrack(board)){
                                return true;
                            }else{
                                board[i][j] = '.'; //backtrack, if invalid
                            }
                        }
                    }
                    
                    return false; //if none of the choices fit, then need to go back to previous point & try diff choices
                }
            }
        }
        
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
}
