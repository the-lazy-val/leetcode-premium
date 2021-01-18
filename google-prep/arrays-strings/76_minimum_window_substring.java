/** My solution: 
265 / 266 test cases passed.
	Status: Time Limit Exceeded
*/
class Solution {
    
    int minIndex = Integer.MAX_VALUE;
    int maxIndex = -1;
    int minLength = Integer.MAX_VALUE;
    
    public boolean compute(HashMap<Character, LinkedList<Integer>> hm){
        LinkedList<Integer> vals = new LinkedList<>();
        for(LinkedList<Integer> li : hm.values()){
            vals.addAll(li);
        }
        
        if(vals.contains(-1)){
            return false;
        }else{
            Collections.sort(vals);
            
            // System.out.println(hm);
            
            int min = vals.getFirst();
            int max = vals.getLast();
        
            int length = max - min + 1;
        
            if(length < minLength){
                minLength = length;
                minIndex = min;
                maxIndex = max;
            }
            return true;
        }
    }
    
    public void insert(HashMap<Character, LinkedList<Integer>> hm, char c, int index){
        LinkedList<Integer> v = hm.get(c);
        v.removeFirst();
        v.addLast(index);
        hm.put(c, v);
    }
    
    public String minWindow(String s, String t) {
        if(s.equals(t)){
            return s;
        }
        
        if(s.length() < t.length()){
            return "";
        }
        
        HashMap<Character, LinkedList<Integer>> hm = new HashMap<>();
        
        int tlen = t.length();
        
        for(char c: t.toCharArray()){
            if(hm.containsKey(c)){
                LinkedList<Integer> v = hm.get(c);
                v.add(-1);
                hm.put(c, v);
            }else{
                LinkedList<Integer> ll = new LinkedList<>();
                ll.add(-1);
                hm.put(c, ll);
            }
        }
        
        boolean flag = false;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                insert(hm, c, i);
                flag = compute(hm);
            }
        }
        
        if(flag){
            return s.substring(minIndex, maxIndex+1);
        }else{
            return "";
        }
    }
}


/**
Sliding Window
*/
class Solution {
  public String minWindow(String s, String t) {

      if (s.length() == 0 || t.length() == 0) {
          return "";
      }

      // Dictionary which keeps a count of all the unique characters in t.
      Map<Character, Integer> dictT = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
          int count = dictT.getOrDefault(t.charAt(i), 0);
          dictT.put(t.charAt(i), count + 1);
      }

      // Number of unique characters in t, which need to be present in the desired window.
      int required = dictT.size();

      // Left and Right pointer
      int l = 0, r = 0;

      // formed is used to keep track of how many unique characters in t
      // are present in the current window in its desired frequency.
      // e.g. if t is "AABC" then the window must have two A's, one B and one C.
      // Thus formed would be = 3 when all these conditions are met.
      int formed = 0;

      // Dictionary which keeps a count of all the unique characters in the current window.
      Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

      // ans list of the form (window length, left, right)
      int[] ans = {-1, 0, 0};

      while (r < s.length()) {
          // Add one character from the right to the window
          char c = s.charAt(r);
          int count = windowCounts.getOrDefault(c, 0);
          windowCounts.put(c, count + 1);

          // If the frequency of the current character added equals to the
          // desired count in t then increment the formed count by 1.
          if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
              formed++;
          }

          // Try and contract the window till the point where it ceases to be 'desirable'.
          while (l <= r && formed == required) {
              c = s.charAt(l);
              // Save the smallest window until now.
              if (ans[0] == -1 || r - l + 1 < ans[0]) {
                  ans[0] = r - l + 1;
                  ans[1] = l;
                  ans[2] = r;
              }

              // The character at the position pointed by the
              // `Left` pointer is no longer a part of the window.
              windowCounts.put(c, windowCounts.get(c) - 1);
              if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                  formed--;
              }

              // Move the left pointer ahead, this would help to look for a new window.
              l++;
          }

          // Keep expanding the window once we are done contracting.
          r++;   
      }

      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}

/**
Optimized Sliding Window

*/
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();  
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;   
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
