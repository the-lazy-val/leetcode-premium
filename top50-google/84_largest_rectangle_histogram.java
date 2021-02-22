/**
Time: O(N)
Space: O(N)

https://www.youtube.com/watch?v=zx5Sw9130L0

*/

class Solution {
    
    class Bar{
        int height;
        int index;
        
        public Bar(int h, int i){
            height = h;
            index = i;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        int maxArea = 0;
        
        Stack<Bar> st = new Stack();
        
        for(int currIndex=0; currIndex<heights.length; currIndex++){
            
            //first bar
            if(currIndex == 0){
                st.push(new Bar(heights[0], 0));
                continue;
            }
            
            int currHeight = heights[currIndex];
            
            //increasing order maintained
            if(currHeight >= st.peek().height){
                st.push(new Bar(currHeight, currIndex));
                continue;
            }
            
            //increasing order broken i.e. smaller bar found
            int extendedIndex = currIndex;
            
            while(!st.isEmpty() && st.peek().height > currHeight){
                
                int topBarHeight = st.peek().height;
                int topBarIndex = st.peek().index;
                
                int distance = (currIndex - topBarIndex);
                
                //means area if this bar is fully included
                int areaForTopBar = topBarHeight * distance;
                
                maxArea = Math.max(areaForTopBar, maxArea);
                
                /**
                because stack will only have increasing order bars
                and since the currBar is less height, we keep removing from stack
                until we find a lower height bar
                because, for ex: 2, 1, 5, 6
                calculation for 6 should only go back till 1
                because we do topBarHeight * distance
                if we consider 2, then '1' after it which is of less height 
                will also become part of  the distance, but it shouldn't since its of less height
                */
                st.pop();
                
                /**
                e.g: 2, 1
                if we pop() '2', the '1' can actually be extended backward
                so we update extendedIndex to lastPoppedBar's index
                */
                extendedIndex = topBarIndex;
            }
            
            st.push(new Bar(currHeight, extendedIndex));
        }
        
        int size = heights.length;
        while(!st.isEmpty()){
            
            Bar topBar = st.pop();
            
            int topBarHeight = topBar.height;
            int topBarIndex = topBar.index;
            
            /**
            because every bar after it must have been of greater height
            e.g: 2,3,4,5,6
            since all are increasing, so we consider distance from: "currIndex" till "end"
            */
            int distance = size - topBarIndex;
            
            int areaForTopBar = topBarHeight*distance;
            maxArea = Math.max(areaForTopBar, maxArea);
        }
        
        return maxArea;
    }
}
