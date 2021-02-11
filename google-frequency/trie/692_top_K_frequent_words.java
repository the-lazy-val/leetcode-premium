class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap();
        
        for(String w : words){
            if(hm.containsKey(w)){
                hm.put(w, hm.get(w)+1);
            }else{
                hm.put(w, 1);
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            pq.add(e);
        }
        
        List<String> res = new ArrayList<>();
        
        while(k>0 && !pq.isEmpty()){
            res.add(pq.poll().getKey());
            k--;
        }
        
        return res;
    }
}
