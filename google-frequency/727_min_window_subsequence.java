/**
No need to use Priority Queue
*/

class Solution {
    
    public String minWindow(String S, String T) {
        
        String ans = "";
        
        int i=0;
        int j=0;
        
        int count=0;
        
        while(i<S.length()){
            while(i < S.length() && S.charAt(i) != T.charAt(0)){
                i++;
            }
            
            if(i<S.length() && S.charAt(i) == T.charAt(0)){
                count=1;
                
                j=i+1;
                while(count < T.length() && j<S.length()){
                    if(S.charAt(j) == T.charAt(count)){
                        count++;
                    }
                    j++;
                }
            
                
                if(count==T.length()){
                    if(ans.length()==0 || j-i < ans.length()){
                        ans=S.substring(i,j);
                    }
                    count=0;
                }
            }
            
            i+=1;
        }
        
        
        return ans;
    }
}

//older solution where i was using priority queue

class Solution {
    
    public int compare(Pair<Integer,  Integer> a, Pair<Integer, Integer> b){
        int lenA = a.getValue() - a.getKey();
        int lenB = b.getValue() - b.getKey();
        
        if(lenA == lenB){
            return (a.getKey() - b.getKey());
        }else{
            return lenA - lenB;
        }
    }
    
    public String minWindow(String S, String T) {
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> compare(a, b));
        
        int i=0;
        int j=0;
        
        int count=0;
        
        while(i<S.length() && j<S.length()){
            while(i < S.length() && S.charAt(i) != T.charAt(0)){
                i++;
            }
            
            if(i<S.length() && S.charAt(i) == T.charAt(0)){
                count=1;
                
                j=i+1;
                while(count < T.length() && j<S.length()){
                    if(S.charAt(j) == T.charAt(count)){
                        count++;
                    }
                    j++;
                }
            
                if(count==T.length()){
                    pq.add(new Pair(i, j));
                    count=0;
                    i+=1;
                }
            }
        }
        
        if(pq.isEmpty()) return ""; else {
            Pair<Integer, Integer> ans = pq.poll();
            return S.substring(ans.getKey(), ans.getValue());
        }
    }
}
