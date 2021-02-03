/**
Time: O(N)
Space: O(N)

https://www.youtube.com/watch?v=zx5Sw9130L0

*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        
        int maxArea = 0;
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        
        for(int i=0; i<heights.length; i++){
            if(st.isEmpty()){
                st.push(new Pair(i, heights[i]));
            }else{
                
                if(heights[i] >= st.peek().getValue()){
                    st.push(new Pair(i, heights[i]));
                }else{
                    int newIndex = i;
                    while(!st.isEmpty() && heights[i] < st.peek().getValue()){
                        Pair<Integer, Integer> topElement = st.pop();
                        int currArea = (i-topElement.getKey())*topElement.getValue();
                        maxArea = Math.max(currArea, maxArea);
                        newIndex = topElement.getKey();
                    }
                    st.push(new Pair(newIndex, heights[i]));
                }
            }
        }
        
        int size = heights.length;
        while(!st.isEmpty()){
            Pair<Integer, Integer> top = st.pop();
            int currArea = (size - top.getKey())*top.getValue();
            maxArea = Math.max(currArea, maxArea);
        }
        
        return maxArea;
    }
}
