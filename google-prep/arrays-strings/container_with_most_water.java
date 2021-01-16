/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

Example 3:

Input: height = [4,3,2,1,4]
Output: 16

Example 4:

Input: height = [1,2,1]
Output: 2

Constraints:

    n == height.length
    2 <= n <= 3 * 104
    0 <= height[i] <= 3 * 104


*/

/**
hint: Start with the maximum width container and go to a shorter width container if there is a vertical line longer than the current containers shorter line. This way we are compromising on the width but we are looking forward to a longer length container.
*/

//My solution:
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int h = 0;
        int distance = 0;
        int curr = 0;
        int max = 0;
        
        int heighti=0;
        int heightj=0;
        
        int nexti=0;
        int nextj=0;
        
        while(i < j){
            heighti = height[i];
            heightj = height[j];
            
            h = Math.min(heighti, heightj);
            distance = j - i;
            
            curr = h * distance;
            max = Math.max(max, curr);
            
            if(heighti < heightj){
                i++;
            }else{
                j--;
            }
        }
        
        return max;
    }
}

// Runtime: 3 ms

// Same solution, but we can avoid the extra variables I declared:
class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        
        int l = 0;
        int r = n-1;
        int max = 0;
        
        while(l < r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r-l));
            
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
