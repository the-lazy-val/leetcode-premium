class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int maxSize = 0;
        int count = 0;
        
        for(int[] r : rectangles){
            
            int squareSize = Math.min(r[0], r[1]);
            
            if(squareSize == maxSize){
                count++;
            }
            else if(squareSize > maxSize){
                maxSize = squareSize;
                count = 1;
            }
        }
        
        return count;
    }
}
