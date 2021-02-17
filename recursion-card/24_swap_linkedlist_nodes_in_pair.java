class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
        ListNode temp = head.next.next;
        ListNode h = head;
        head=head.next;
        head.next=h;
        h.next=swapPairs(temp);
        return head;
    }
}
