class Solution {
    
    class Node{
        String key;
        double value;
        public Node(String k, double v){
            key = k;
            value = v;
        }
    }
    
    public HashMap<String, List<Node>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String, List<Node>> g = new HashMap<>();
        
        for(int i=0; i<equations.size(); i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            g.putIfAbsent(src, new ArrayList());
            g.putIfAbsent(dest, new ArrayList());
            
            g.get(src).add(new Node(dest, values[i]));
            g.get(dest).add(new Node(src, 1/values[i]));
        }
        
        return g;
    }
    
    public double dfs(String s, String d, HashSet<String> visited, HashMap<String, List<Node>> g){
        if(!(g.containsKey(s) && g.containsKey(d))){
            return -1.0;
        }
        
        if(s.equals(d)){
            return 1.0;
        }
        
        visited.add(s);
        for(Node n : g.get(s)){
            if(! visited.contains(n.key)){
                double ans = dfs(n.key, d, visited, g);
                if(ans > 0.0){
                    return ans*n.value;
                }
            }
        }
        
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Node>> g = buildGraph(equations, values);
        
        double[] output = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            
            output[i] = dfs(src, dest, new HashSet(), g);
        }
        
        return output;
    }
}
