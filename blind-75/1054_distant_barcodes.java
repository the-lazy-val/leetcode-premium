class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
		// Use array to store values for convinence
		// arr[0] -> value v, arr[1] -> frequency of v
        
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> {
			// Sort frequency in descending order
            return b[1] - a[1];
        });
        
		// Count times
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i: barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i: map.keySet()) {
            pq.add(new int[] {i, map.get(i)});
        }
        
        int[] ans = new int[barcodes.length];
        int curr = 0;
        int[] temp = pq.poll(); //firstly added highest frequency
        
        while (curr < barcodes.length) {
            ans[curr++] = temp[0];  
            temp[1]--;
            int[] t2 = temp; 
            temp = pq.poll(); //then add second highest frequency
            pq.add(t2); //store back previously polled with count-1
        }
        
        return ans;
    }
}
