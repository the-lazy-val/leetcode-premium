/**
My solution: 9 ms
beats 39 %
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3){
            return s.length();
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        char prev = s.charAt(0);
        hm.put(prev, 1);
        
        int temp = 1;
        int max = 1;
        
        for(char c : s.substring(1).toCharArray()){
            if(hm.containsKey(c)){
                temp++;
                if(c == prev){
                    hm.put(c, hm.get(c)+1);
                }else{
                    hm.put(c, 1);
                }
            }else{
                if(hm.size() == 1){
                    temp++;
                    hm.put(c, 1);
                }else{
                    int previousCount = hm.get(prev);
                    temp = previousCount + 1;

                    hm.clear();
                    hm.put(prev, previousCount);
                    
                    hm.put(c, 1);
                }
            }
            
            prev = c;
            max = Math.max(temp, max);
        }
        
        return max;
    }
}

/**
Better solution: O(N) as well, but takes less time
*/

class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    if (n < 3) return n;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 2;

    while (right < n) {
      // when the slidewindow contains less than 3 characters
      hashmap.put(s.charAt(right), right++);

      // slidewindow contains 3 characters
      if (hashmap.size() == 3) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}
