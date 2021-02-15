class Solution {
    public String minWindow(String S, String T) {
        
        PriorityQueue<Pair<Integer, Integer>> pq = 
            new PriorityQueue<>((a, b) -> (a.getValue()==b.getValue()) ? a.getKey() - b.getKey() : a.getValue()-b.getValue());
        
        int i=0;
        int j=0;
        
        int count=0;
        
        while(i<S.length() && j<S.length()){
            while(S.charAt(i) != T.charAt(0)){
                i++;
            }
            
            count=1;
            j=i+1;
            while(count < T.length() && j<S.length()){
                if(S.charAt(j) == T.charAt(count)){
                    count++;
                }
                j++;
            }
            
            if(count==T.length()){
                int len = j-i;
                pq.add(new Pair(i, len));
                count=0;
                i+=1;
            }
        }
        
        if(pq.isEmpty()) return ""; else {
            Pair<Integer, Integer> ans = pq.poll();
            System.out.println(ans.getKey());
            System.out.println(ans.getValue());
            return "";
        }
    }
}
