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
