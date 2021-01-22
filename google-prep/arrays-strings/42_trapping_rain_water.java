/**
My solution: 3 ms

It uses the concept that, once we have 2 pillars
The effective height, h = min(start, stop)

then for each pillar i in between, we just add (h - height[i])

*/

class Solution {
    public int calculate(int[] height, int start, int stop){
        int res = 0;
        int h = Math.min(height[start], height[stop]);
        for(int i=start+1; i<stop; i++){
            res += (h - height[i]);
        }
        
        return res;
}    

    public int trap(int[] height) {
        int len = height.length;
        if(len <=1){
            return 0;
        }
        int start = 0;
        int stop = 1;
        int curr = 1;
        
        int total = 0;
        
        while(stop <= len-1){
            if(curr == len){
                total += calculate(height, start, stop);
                start = stop;
                stop = start+1;
                curr = stop;
            }
            else if(height[curr] >= height[stop]){
                stop = curr;
                curr++;
                if(height[stop] >= height[start]){
                    total += calculate(height, start, stop);
                    start = stop;
                    stop = start+1;
                    curr = stop;
                } 
            }else{
                curr++;
            }
        }

        return total;
    }
}
