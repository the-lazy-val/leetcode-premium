class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        
        double min = Double.MAX_VALUE;
        
        for(int captain=0; captain<wage.length; captain++){
            
            double captainRatio = (double)wage[captain]/quality[captain];
            
            PriorityQueue<Double> pq = new PriorityQueue();
            
            for(int worker=0; worker<wage.length; worker++){
                
                double workerOffer = captainRatio * quality[worker];
                
                if(workerOffer >= wage[worker]) pq.add(workerOffer);
                
            }
            
            if(pq.size() < K) continue;
            
            int count = 0;
            double currTotal = 0.0;
            while(count < K){
                currTotal += pq.poll();
                count++;
            }
            
            min = Math.min(min, currTotal);
        } 
        
        return min;
    }
}
