/**
My solution using binary search

very slow: 600 ms
beats 5%
*/

class Solution {
    
    public boolean find(int[] hand, int elem, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(hand[mid] == -1){
                if(find(hand, elem, start, mid-1)){
                    return true;
                }else return find(hand, elem, mid+1, end);
            }
            else if(hand[mid] == elem){
                hand[mid] = -1;
                return true;
            }else if(hand[mid] < elem){
                return find(hand, elem, mid+1, end);
            }else{
                return find(hand, elem, start, mid-1);
            }
        }
        
        return false;
    }
    
    public boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if(len % W != 0) return false;
        
        Arrays.sort(hand);
        
        for(int i=0; i<len; i++){
            int elem = hand[i];
            if(elem != -1) {
                hand[i] = -1;
                int k = W-1;
                elem+=1;
                while(k>0){
                    if(find(hand, elem, i+1, len-1)){
                        k--;
                        elem+=1;
                    } else return false;
                }
            }
        }
        
        return true;
    }
}
