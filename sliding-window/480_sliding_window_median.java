class Solution {
    
    PriorityQueue<Integer> leftMax = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> rightMin = new PriorityQueue();
    
    public void addElement(int elem){
        leftMax.add(elem);
        
        if(!leftMax.isEmpty() && !rightMin.isEmpty() && leftMax.peek() > rightMin.peek()){
            rightMin.add(leftMax.poll());
        }
        
        int leftSize = leftMax.size();
        int rightSize = rightMin.size();
        
        if(leftSize-rightSize > 1){
            int temp = leftMax.poll();
            rightMin.add(temp);
        }else if(rightSize-leftSize > 1){
            int temp = rightMin.poll();
            leftMax.add(temp);
        }
    }
    
    public void removeElement(int elem){
        if(leftMax.contains(elem)){
            leftMax.remove(elem);
        }else{
            rightMin.remove(elem);
        }
        
        int leftSize = leftMax.size();
        int rightSize = rightMin.size();
        
        if(leftSize-rightSize > 1){
            int temp = leftMax.poll();
            rightMin.add(temp);
        }else if(rightSize-leftSize > 1){
            int temp = rightMin.poll();
            leftMax.add(temp);
        }
        
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int i = 0;
        while(i < k){
            addElement(nums[i]);
            i++;
        }
        
        List<Double> output = new ArrayList();
        
        while(i <= nums.length){
            
            if(k % 2 == 0){
                double left = (double) leftMax.peek();
                double right = (double) rightMin.peek();
                
                output.add((left+right)/2.0);
            }else{
                // double left = (double) leftMax.peek(); //maybe top of the heap which has more elements ???
                
                double median = (leftMax.size() > rightMin.size()) ? (double) leftMax.peek() : (double) rightMin.peek();
                
                output.add(median);
            }
            
            if(i==nums.length) break;
            
            int rem = nums[i-k];
            removeElement(rem);
            addElement(nums[i]);
            i++;
        }
        
        return output.stream().mapToDouble(x->x).toArray();
    }
}
