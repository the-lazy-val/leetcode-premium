class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            // curr=curr.next;  // can't do this, because we already pointed curr to prev
            //that's why we have stored next beforehand
            //so
            curr=next;
        }
        
        return prev;
    }
}
