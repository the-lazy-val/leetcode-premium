/**
My approach: Using a priority queue, insert element multiple time as per weights

Time limit exceeds on big input
*/

class Node{
    int value;
    int index;
    
    public Node(int v, int i){
        value=v;
        index=i;
    }
}

class Solution {
    
    PriorityQueue<Node> pq;
    int max;
    
    public Solution(int[] w) {
        max = w.length-1;
        
        pq = new PriorityQueue<Node>((a,b) -> b.value - a.value);
        
        for(int i=0; i<w.length; i++){
            int weight = w[i];
            Node n = new Node(weight, i);
            pq.addAll(Collections.nCopies(weight, n));
        }
    }
    
    public int pickIndex() {
        int random = (int)(Math.random() * pq.size());
        int pick=pq.peek().index;
        
        
        if(random>0){
            ArrayList<Node> li = new ArrayList<>();
            
            for(int i=0; i<random; i++){
                li.add(pq.poll());
            }
            
            pick=pq.peek().index;
            
            pq.addAll(li);
        }
        
        return pick;
    }
}
