//Iterative
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null  || head.next==null) return true;
        
        ListNode h = head;
        
        Stack<ListNode> st = new Stack();
        while(head!=null){
            st.push(head);
            head = head.next;
        }
        
        boolean isPalindrome = true;
        
        while(!st.isEmpty() && isPalindrome){
            
            ListNode top = st.pop();
                
            isPalindrome = isPalindrome && (h.val == top.val);
            
            h=h.next;
        }
        
        return isPalindrome;
    }
}
