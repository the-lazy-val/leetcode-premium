/**
Not my solution
*/

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        
        for(int i=0; i<N; i++){
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        Arrays.sort(workers);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        
        for(Worker w : workers){
            totalQuality += w.quality;
            pq.offer(w.quality);
            
            if(pq.size() > K){
                totalQuality -= pq.poll();
            }
            
            if(pq.size() == K){
                cost = Math.min(cost, totalQuality * w.getRatio());
            }
        }
        
        return cost;
    }
}

class Worker implements Comparable<Worker>{
    int quality;
    int wage;
    
    public Worker(int q, int w){
        quality = q;
        wage = w;
    }
    
    public double getRatio(){
        return (double) wage/quality;
    }
    
    public int compareTo(Worker other){
        if(this.getRatio() > other.getRatio()){
            return 1;
        }else if(this.getRatio() < other.getRatio()){
            return -1;
        }else{
            return 0;
        }
    }
}
