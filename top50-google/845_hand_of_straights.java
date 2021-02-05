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


/**
Better solution using TreeMap
*/

public boolean isNStraightHand(int[] hand, int W) {
    if (hand == null || hand.length == 0) return true;
    if (hand.length % W != 0) return false;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int curr : hand) map.put(curr, map.getOrDefault(curr, 0) + 1);     // O(nlogn) time.
    while (map.size() > 0) {
        // Try creating the next group of W consecutive cards.
        int start = map.firstKey();                 // O(logn) time.
        for (int i = start; i < start + W; ++i) {
            if (!map.containsKey(i)) return false;  // O(logn) time.
            map.put(i, map.get(i) - 1);             // O(logn) time.
            if (map.get(i) == 0) map.remove(i);     // O(logn) time.
        }
    }
    return true;
}
