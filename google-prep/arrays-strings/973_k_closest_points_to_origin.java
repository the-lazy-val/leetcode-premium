/**
My solution: 26ms
beats 52 %
memory: beats 81 %
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

/**
Instead of adding extra elements to the heap, poll if size exceeds K
But since poll removes the highest priority (samllest distance), we reverse the comparator by multiplying -1

*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(points.length, (int[] a, int[] b) -> -1*(
                (a[0]-b[0])*(a[0]+b[0]) + (a[1]-b[1])*(a[1]+b[1])
            ));
        
        int counter = 0;
        
        for(int[] e : points){
            counter++;
            pq.add(e);
            if(counter > K){
                pq.poll();
            }
        }
        
        return pq.toArray(new int[K][2]);
    }
}
