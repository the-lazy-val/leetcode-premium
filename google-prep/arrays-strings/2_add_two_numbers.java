/**
My solution: 2ms
beats 77%
memory beats 96%
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = null;
        ListNode head = null;

        while(l1!=null && l2!=null){
            int add = l1.val + l2.val + carry;
            int digit = add%10;
            carry = add/10;

            if(dummy==null){
                dummy= new ListNode(digit);
                head = dummy;
            }else{
                dummy.next = new ListNode(digit);
                dummy = dummy.next;
            }
            
            l1 = l1.next;
            l2=l2.next;
        }

        ListNode temp = null;
        if(l1 != null) temp=l1; else temp=l2;

        while(temp != null){
            int add = temp.val + carry;
            int digit = add%10;
            carry = add/10;

            dummy.next = new ListNode(digit);
            dummy = dummy.next;
            temp = temp.next;
        }

        if(carry > 0){
            dummy.next = new ListNode(carry);
            dummy = dummy.next;
        }

        return head;
    }
}
