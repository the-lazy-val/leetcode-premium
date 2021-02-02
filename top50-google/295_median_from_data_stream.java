/**

https://www.youtube.com/watch?v=itmhHWaHupI

Use the property of median:
- all left element <= all right element [maxLeft <= minRight]
- both side balanced size [+/- 1 allowed]

To mainatin max & min on 2 sides, we use maxHeap for left & minHeap for right

as we enter element, we balance heaps based on the above 2 properties

Heap: 
Insertion/Removal: O(N)
Find Min / Max: O(1)
*/

class MedianFinder {

    boolean isOdd = false;
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        left.add(num);
        
        if(right.size() > 0){
            int rightMin = right.peek();
            if(num > rightMin){
                left.poll();
                right.add(num);
            }
        }
        
        if(left.size() - right.size() > 1){
            right.add(left.poll());
        }
        
        if(right.size() - left.size() > 1){
            left.add(right.poll());
        }
        isOdd = !isOdd;
    }
    
    public double findMedian() {
        if(isOdd){
            if(left.size() >= right.size())
                return (double) left.peek();
            else
                return (double) right.peek();
        }else{
            return ((double)left.peek() + (double) right.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
