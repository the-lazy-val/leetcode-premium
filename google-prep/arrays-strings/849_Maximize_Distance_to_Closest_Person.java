/**
My solution: 2 ms
beats 74%
*/

class Solution {
    
    public int checkMax(int currmax, int[] seats, int start, int end){
        int max = currmax;
                    if(start == end){
                        if(1 > max){
                            max = 1;
                         }
                    }else if(start == 0){
                        if(end-start+1 > max){
                            max = end-start+1;
                        }
                    }else if(end == seats.length-1){
                        if(end-start+1 > max){
                            max = end-start+1;
                        }
                    }else{
                        int distance = (end-start)/2;
                        if(distance+1 > max){
                            max = distance+1;
                        }
                    }
        return max;
    }
    
    public int maxDistToClosest(int[] seats) {
        
        int max = -1;
        
        int start = -1;
        int end = -1;
        boolean flag = false;
        
        for(int i=0; i<seats.length; i++){
            if(!flag && seats[i] == 0){
                flag = true;
                start = i;
            }else{
                if(flag && seats[i] == 0){
                    end = i;
                }
                if(flag && seats[i] == 1){
                    flag = false;
                    end = i-1;
                    
                    max = checkMax(max, seats, start, end);
                }
            }
        }
        
        if(flag){
            max = checkMax(max, seats, start, end);
        }
        
        return max;
    }
}

/**
LC solution: 
Approach #1: Next Array

Let left[i] be the distance from seat i to the closest person sitting to the left of i. Similarly, let right[i] be the distance to the closest person sitting to the right of i. This is motivated by the idea that the closest person in seat i sits a distance min(left[i], right[i]) away.

Algorithm

To construct left[i], notice it is either left[i-1] + 1 if the seat is empty, or 0 if it is full. right[i] is constructed in a similar way.



    Time Complexity: O(N), where N is the length of seats.

    Space Complexity: O(N), the space used by left and right.
*/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }
}


/**
LC solution
Approach #2: Two Pointer 

Intuition

As we iterate through seats, we'll update the closest person sitting to our left, and closest person sitting to our right.

Algorithm

Keep track of prev, the filled seat at or to the left of i, and future, the filled seat at or to the right of i.

Then at seat i, the closest person is min(i - prev, future - i), with one exception. i - prev should be considered infinite if there is no person to the left of seat i, and similarly future - i is infinite if there is no one to the right of seat i.




Time Complexity: O(N), where NNN is the length of seats.

Space Complexity: O(1)
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }
}


/**
LC solution
Approach #3: Group by Zero

My approach
*/
