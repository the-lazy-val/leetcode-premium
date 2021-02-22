/**
Average: O(N log N)
Worst: O(N^2) => since if input array is sorted, it will take us O(N) time to find minIndex
*/

class Solution {
    
    public int getLargestInRange(int[] heights, int start, int end){
        if(start>end) return 0;
        
        int minIndex = start;
        for(int i=start; i<=end; i++){
            if(heights[i] <= heights[minIndex]){
                minIndex = i;
            }
        }
        
        int currArea = heights[minIndex] * (end-start+1);
        
        int leftMax = getLargestInRange(heights, start, minIndex-1);
        int rightMax = getLargestInRange(heights, minIndex+1, end);
        
        return Math.max(currArea, Math.max(leftMax, rightMax));
    }
    
    public int largestRectangleArea(int[] heights) {
        return getLargestInRange(heights, 0, heights.length - 1);
    }
}
