/**
My solution: 0ms
fastest solution
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode head = start;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                start.next = l1;
                l1 = l1.next;
            }else{
                start.next = l2;
                l2=l2.next;
            }
            start = start.next;
        }

        ListNode dummy = null;
        if(l1 !=null) dummy = l1; else dummy=l2;
        
        while(dummy!=null){
            start.next = dummy;
            dummy=dummy.next;
            start = start.next;
        }
        return head.next;
    }
}
