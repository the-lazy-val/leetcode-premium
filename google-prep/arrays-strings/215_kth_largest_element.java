/**
My solution using Priority queue
Time: O(N log k)
Space: O(N)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums){
            pq.add(n);
        }
        
        int res = 0;
        int i = k;
        while(i > 0){
            int num = pq.poll();
            if(i == 1){
                res = num;
            }
            i--;
        }
        
        return res;
        
         // another way:
        // Arrays.sort(nums);
        // return nums[nums.length - k];
    }
}


/**
Better space complexity

don't add everything, keep only k in the heap / priority queue
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.poll();        
  }
}
