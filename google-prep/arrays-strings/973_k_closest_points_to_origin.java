/**
My solution: 29ms
using priority queue
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(points.length, (int[] a, int[] b) -> (
                (a[0]-b[0])*(a[0]+b[0]) + (a[1]-b[1])*(a[1]+b[1])
            ));
        
        for(int[] e : points){
            pq.add(e);
        }
        
        int[][] res = new int[K][2];
        
        while(K > 0){
            int[] e = pq.poll();
            res[K-1][0] = e[0];
            res[K-1][1] = e[1];
            K--;
        }
        
        return res;
    }
}
