/**
My solution: 1ms
beats 15%
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode end = head;

        int count = 1;
        while(count < n){
            end = end.next;
            count++;
        }

        while(end.next != null){
            end = end.next;
            start = start.next;
        }
        
        if(start.next == head){
            head = start.next.next;
        }else{
            start.next = start.next.next;
        }
        
        return head;
    }
}
