class Solution {
    
    class Edge{
        int source;
        int target;
        int weight;
        
        public Edge(int s, int t, int w){
            source = s;
            target = t;
            weight = w;
        }
    }
    
    class Node{
        int vertexId;
        int sourceVertex;
        int wt;
        
        public Node(int v, int sv, int w){
            vertexId = v;
            sourceVertex = sv;
            wt = w;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, ArrayList<Edge>> adj = new HashMap<>();
        
        int len = points.length;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.computeIfAbsent(i, x -> new ArrayList()).add(new Edge(i, j, distance));//since undirected
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Node(0, -1, 0));//starting with dummy sourceVertex
        
        HashSet<Integer> visited = new HashSet();
        
        int cost = 0;
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            if(visited.contains(curr.vertexId)) continue;
            
            // System.out.println("vertex: "+curr.vertexId+" ,path: "+curr.sourceVertex+" ,cost: "+curr.wt);
            cost += curr.wt;
            
            visited.add(curr.vertexId);
            
            for(Edge e : adj.get(curr.vertexId)){
                if(! visited.contains(e.target)){
                    pq.add(new Node(e.target, curr.vertexId, e.weight));
                }
            }
        }
        
        return cost;
    }
}
