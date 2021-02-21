class Solution {
    
    public boolean search(int[][] matrix, int lowX, int highX, int lowY, int highY, int target){

        if(lowX > highX || lowY > highY){ //this means empty matrix
            return false;
        }else if(target < matrix[lowX][lowY] || target > matrix[highX][highY]){
            
            //since (lowX, lowY) signify smallest elemwnt & (highX, highY) signify largest element in submatrix
            //if target doesn't fall in this range, it doesn't exist in matrix
            
            return false;
        }
        
        int midY = lowY + (highY-lowY)/2; //get the middle column
        
        //Now in this middle column, go down to the point where (row, midY) <= target
        int row = lowX;
        while(row <= highX && matrix[row][midY] <= target){
            
            if(matrix[row][midY] == target){ //while going down if we find target, the return true
                return true;
            }
            row++;
        }
        
        //if target not found till now, search top-right & bottom-left
        return search(matrix, row, highX, lowY, midY-1, target) || search(matrix, lowX, row-1, midY+1, highY, target);
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int lowX = 0;
        int highX = matrix.length-1;
        int lowY = 0;
        int highY = matrix[0].length-1;
        
        return search(matrix, lowX, highX, lowY, highY, target);
    }
}
