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
