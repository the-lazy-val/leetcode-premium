/**
My solution: 7ms
beats 60 %
*/
class Solution {
    
    public int nextBig(int[] sorted, int curr, int limit){
        for(int i=0; i<4; i++){
            if(sorted[i] > curr && sorted[i] <= limit){
                return sorted[i];
            }
        }
        return sorted[0];
    }
    
    public String nextClosestTime(String time) {
        char[] arr = time.toCharArray();
        
        int[] digits = new int[]{arr[0] - '0',  arr[1] - '0', arr[3] - '0', arr[4] - '0'};
        int[] sorted = new int[]{arr[0] - '0',  arr[1] - '0', arr[3] - '0', arr[4] - '0'};
        
        Arrays.sort(sorted);
        
        for(int i = 3; i>= 0; i--){
            
            int curr = digits[i];
            
            if(i == 3){
                digits[i] = nextBig(sorted, curr, 9);
            }
            if(i == 2){
                digits[i] = nextBig(sorted, curr, 5);
            }
            if(i == 1){
                if(digits[0] == 2){
                    digits[i] = nextBig(sorted, curr, 3);
                }else{
                    digits[i] = nextBig(sorted, curr, 9);
                }
            }
            if(i == 0){
                digits[i] = nextBig(sorted, curr, 2);
            }
            
            if(digits[i] > curr){
                break;
            }
        }
        
        String res = 
            Integer.toString(digits[0]) + Integer.toString(digits[1]) + ":" + Integer.toString(digits[2]) + Integer.toString(digits[3]);
        
        return res;
    }
}
