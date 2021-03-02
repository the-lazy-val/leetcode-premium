class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode oddHead = new ListNode();
        ListNode oddDummy = oddHead;
        
        ListNode evenHead = new ListNode();
        ListNode evenDummy = evenHead;
        
        while(head!=null){
            ListNode odd = head;
            ListNode even = head.next;
            
            oddDummy.next = odd;
            oddDummy = oddDummy.next;
            
            evenDummy.next = even;
            evenDummy = evenDummy.next;
            
            if(even==null){
                break;
            }
            
            head = even.next;
        }
        
        oddDummy.next = evenHead.next;
        return oddHead.next;
    }
}
