/**
4ms
O(N log A)
N -> size of S
A -> size of heap, i.e. number of chars

beats 46%

Use PriorityQueue to place most ocurring character, just keep track of last character placed (if so, place the next priority element)
*/

class Solution {
    
    public String rearrange(StringBuilder sb, PriorityQueue<Pair<Character, Integer>> pq, int len){
        char curr = '1';
        while(len > 0){
            Pair<Character, Integer> polled = pq.poll();
            
            if(curr == polled.getKey()){
                if(pq.isEmpty()) return "";
                
                Pair<Character, Integer> temp = pq.poll();
                pq.add(polled);
                polled = temp;
            }
            
            char polledKey = polled.getKey();
            int polledValue = polled.getValue();
            sb.append(polledKey);
            curr=polledKey;
            if(polledValue > 1) pq.add(new Pair(polledKey, polledValue-1));
            len--;
        }
        return sb.toString();
    }
    
    public String reorganizeString(String S) {
        
        if(S.length() ==0) return "";
        
        PriorityQueue<Pair<Character, Integer>> pq = 
            new PriorityQueue<>((Pair<Character, Integer> a, Pair<Character, Integer> b) -> b.getValue() - a.getValue()); //Max Heap based on counts
            
//         HashMap<Character, Integer> hm = new HashMap<>();
        
//         for(char c : S.toCharArray()){
//             hm.putIfAbsent(c, 0);
//             hm.put(c, hm.get(c)+1);
//         }
        
//         for(Map.Entry<Character, Integer> e : hm.entrySet()){
//             pq.add(new Pair(e.getKey(), e.getValue()));
//         }
        
        int[] count = new int[26];
        for(char c : S.toCharArray()){
            int index = c - 'a';
            count[index] += 1;
        }
        
        for(int i=0; i<26; i++){
            if(count[i] > 0){
                pq.add(new Pair((char)('a'+i), count[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        return rearrange(sb, pq, S.length());
    }
}
