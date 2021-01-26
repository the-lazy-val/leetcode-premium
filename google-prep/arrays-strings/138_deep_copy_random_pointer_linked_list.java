/**
My solution: 1 ms
beats 13-14 %
*/

//first directly copy all nodes with next
//then use map to reference randoms

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        HashMap<Node, Integer> nodeIndex = new HashMap<>();
        HashMap<Node, Integer> nodeRandomIndex = new HashMap<>();
        
        int count = 0;
        Node curr = head;
        while(curr!=null){
            nodeIndex.put(curr, count);
            count++;
            curr = curr.next;
        }
        
        curr = head;
        while(curr!=null){
            if(curr.random == null){
                nodeRandomIndex.put(curr, -1);
            }else{
                nodeRandomIndex.put(curr, nodeIndex.get(curr.random));
            }
            
            curr = curr.next;
        }
        
        
        HashMap<Integer, Node> hm = new HashMap<>();
        
        curr = head;
        Node dummy = null;
        Node copy = null;
        count = 0;
        
        while(curr != null){
            if(dummy == null){
                dummy = new Node(curr.val);
                copy = dummy;
            }else{
                dummy.next = new Node(curr.val);
                hm.put(count-1, dummy);
                dummy = dummy.next;
            }
            
            count++;
            curr = curr.next;
        }
        
        hm.put(count-1, dummy);
        
        curr = head;
        dummy = copy;
        count=0;
        while(curr != null){
            
            int randomIndex = nodeRandomIndex.get(curr);
            if(randomIndex == -1){
                dummy.random = null;
            }else{
                dummy.random = hm.get(randomIndex);
            }
            
            count++;
            curr=curr.next;
            dummy = dummy.next;
        }
        
        return copy;
    }
}
