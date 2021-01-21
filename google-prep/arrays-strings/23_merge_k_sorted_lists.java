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
