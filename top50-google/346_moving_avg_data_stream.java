/**
Time: O(1)
Space: O(N)
*/

class MovingAverage {

    int[] nums;
    int curr;
    int cap;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
        cap=size;
        curr=0;
        sum=0;
    }
    
    public double next(int val) {
        if(curr<cap){
            nums[curr] = val;
            sum+=val;
            curr++;
            return ((double)sum/curr);
        }else{
            int temp = curr%cap;
            sum-=nums[temp];
            nums[temp]=val;
            sum+=val;
            curr++;
            return ((double)sum/cap); 
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
