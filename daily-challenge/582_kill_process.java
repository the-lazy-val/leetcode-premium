class Solution {
    
    HashMap<Integer, ArrayList<Integer>> parentToChild = new HashMap();
    
    public void delete(int parent, LinkedList<Integer> res){
        res.add(parent);
        if(parentToChild.containsKey(parent)){
            for(int child : parentToChild.get(parent)){
                delete(child, res);
            }
        }
    }
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for(int i=0; i<ppid.size(); i++){
            parentToChild.computeIfAbsent(ppid.get(i), x -> new ArrayList()).add(pid.get(i));
        }
        
        LinkedList<Integer> res = new LinkedList();
        
        delete(kill, res);
        
        return res;
    }
}
