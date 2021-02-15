/**
Similar to 857
Here we need to maximize performance, as opposed to minimizing cost in 857
*/

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] efficiencyAndSpeed = new int[n][2];
        
        for(int worker=0; worker<n; worker++){
            efficiencyAndSpeed[worker][0] = efficiency[worker];
            efficiencyAndSpeed[worker][1] = speed[worker];
        }
        
        Arrays.sort(efficiencyAndSpeed, (a,b) -> b[0]-a[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long speedSum=0;
        long max=0;
        
        for(int worker=0; worker<n; worker++){
            speedSum += efficiencyAndSpeed[worker][1];
            pq.offer(efficiencyAndSpeed[worker][1]);
            
            if(pq.size() > k) speedSum-=pq.poll(); //removing the worker which has slowest speed
            
            /**
            This is similar to case of hiring K workers
            There equation was:
            cost = ratio[captain] * (quality[0]+quality[1]....) //lowest K qualities 
            and we had to minimize cost
            
            In this case the equation is:
            performance = efficiency[captain] * (speed[0]+speed[1]....) //top K speeds
            and we have to maximize performance
            */
            
            //Note: not checking pq.size == k, before updating min,as in case of 857 because this question specifies at most k workers (not exactly K workers)
            max = Math.max(max, speedSum * efficiencyAndSpeed[worker][0]);
        }
        
        return (int) (max % (long) (1e9 + 7));
    }
}
