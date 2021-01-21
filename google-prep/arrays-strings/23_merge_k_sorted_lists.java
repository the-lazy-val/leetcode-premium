/**
My solution: 272 ms
Slow, because it traverses through first element of each LinkedList in array for each entry
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        lists = Arrays.stream(lists).filter(s -> s != null).toArray(ListNode[]::new);
        if(lists.length == 0){
            return null;
        }
        ListNode head = null;
        ListNode res = null;
        int k = lists.length;
        
        boolean flag = true;
        boolean check = true;
        
        while(flag){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for(int i=0; i<k; i++){
                ListNode l = lists[i];
                
                if(l != null){
                    int val = l.val;
                    if(val < min){
                        min = val;
                        minIndex = i;
                    }
                }
            }
            
            if(minIndex != -1){
                if(check){
                    res = new ListNode(min, null);
                    head = res;
                    check = false;
                }else{
                    res.next = new ListNode(min, null);
                    res = res.next;
                }
                lists[minIndex] = lists[minIndex].next;
            }else{
                flag = false;
            }
        }
        return head;
    }
}

/**
Better solution: 4 ms

Using Priority Queue
*/
/***

Insert and remove from Priority Queue cost logK

Since there are N final elements in merged list we will do this operation N times.

so final complexity is NlogK
**/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> a.val-b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
