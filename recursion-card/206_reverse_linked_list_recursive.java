class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
        ListNode end = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return end;
    }
}
