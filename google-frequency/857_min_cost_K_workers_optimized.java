//Better readability
//https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/727927/Java-Same-Template-for-2-similar-questions

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        Pair<Double, Integer>[] ratioAndQuality = new Pair[wage.length];
        
        for(int worker=0; worker<wage.length; worker++){
            double workerRatio = (double)wage[worker]/quality[worker];
            ratioAndQuality[worker] = new Pair(workerRatio, quality[worker]);
        }
        
        /**
        Following the first rule: offer[x] >= wage[x]
        => quality[x] * ratio[captain] >= wage[x]
        => ratio[captain] >= ratio[x]
        
        So, only that captain can be selected later, who has atlest k-1 workers with lower ratio
        */
        Arrays.sort(ratioAndQuality, (a,b) -> Double.compare(a.getKey(), b.getKey()));
        
        PriorityQueue<Integer> topKpq = new PriorityQueue(Collections.reverseOrder()); //descending, as we will maintain only lowest K
        int qualitySum=0;
        
        double min = Double.MAX_VALUE;
        
        for(int worker=0; worker<wage.length; worker++){
            qualitySum += ratioAndQuality[worker].getValue();
            topKpq.offer(ratioAndQuality[worker].getValue());
            
            if(topKpq.size() > K) qualitySum-= topKpq.poll(); //removing the higher quality worker
            
            //doing == K, because exactly K workers need to be hired
            if (topKpq.size() == K) min = Math.min(min, qualitySum * ratioAndQuality[worker].getKey());
        }
        
        return min;
    }
}



class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        
        double min = Double.MAX_VALUE;
        
        Pair<Double, Integer>[] ratioAndQuality = new Pair[wage.length];
        
        for(int worker=0; worker<wage.length; worker++){
            double workerRatio = (double)wage[worker]/quality[worker];
            ratioAndQuality[worker] = new Pair(workerRatio, quality[worker]);
        }
        
        /**
        Following the first rule: offer[x] >= wage[x]
        => quality[x] * ratio[captain] >= wage[x]
        => ratio[captain] >= ratio[x]
        
        So, only that captain can be selected later, who has atlest k-1 workers with lower ratio
        */
        Arrays.sort(ratioAndQuality, (a,b) -> Double.compare(a.getKey(), b.getKey()));
        
        // System.out.println(Arrays.toString(ratioAndQuality));
        
        PriorityQueue<Integer> topKpq = new PriorityQueue(Collections.reverseOrder()); //descending, as we will maintain only lowest K
        int qualitySum=0;
        
        for(int worker=0; worker<K; worker++){ //0 - k-1 as they can never be captain
            topKpq.add(ratioAndQuality[worker].getValue());
            qualitySum+=ratioAndQuality[worker].getValue();
        }
        
        double captainRatio = ratioAndQuality[K-1].getKey(); //since this is the first valid captain
        double currCost = captainRatio * qualitySum;
        
        min = Math.min(min, currCost);
        
        //now checking other captains
        for(int captain=K; captain<wage.length; captain++){
            
            captainRatio = ratioAndQuality[captain].getKey();
            
            int captainQuality = ratioAndQuality[captain].getValue();
            
            if(!topKpq.isEmpty() && captainQuality < topKpq.peek()){
                qualitySum = qualitySum - topKpq.poll();
                
                topKpq.add(captainQuality);
                
                qualitySum += captainQuality;
                
                currCost = captainRatio * qualitySum;
                
                min = Math.min(min, currCost);
            }
            
        }
        
        return min;
    }
}
