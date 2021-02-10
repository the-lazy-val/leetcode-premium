public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        
        /**
        starting from the last index, we are checking if the jump value at that index
        can let us reach the last position or not.
        
        If it can, then that position itself becomes the lastPos,
        becasue if any index before can reach here, it can aslo reach actual lastPosition
        */
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
