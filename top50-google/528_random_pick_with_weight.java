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


/**
Using buckets + binary search
*/

class Solution {
    
    int[] cumulative;
    int sum;
    Random rand;
    
    public Solution(int[] w) {
        int len = w.length;
        cumulative = new int[len];
        
        cumulative[0] = w[0];
        
        for(int i=1; i<len; i++){
            cumulative[i] = w[i] + cumulative[i-1];
        }
        
        sum = cumulative[len-1];
        rand = new Random();
    }
    
    public int pickIndex() {
        int randomValue = rand.nextInt(sum) + 1; // since this generates only 0 to sum-1, adding 1 after
        
        int l=0, r=cumulative.length-1;
        while(l+1<r) {
            int mid = l + (r-l)/2;
            if(randomValue <= cumulative[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return cumulative[l] >= randomValue ? l : r;
    }
}
