/**
BST TLE
*/
class Solution {
    
    class Node{
        int val;
        Node left;
        Node right;
        int smaller;
        
        public Node(int v){
            smaller=1;
            val=v;
            left=null;
            right=null;
        }
    }
    
    public int insert(Node root, int newval){

            Node temp = root;
            int count=0;
            while(temp!=null){
                if(newval > temp.val){
                    
                    count+= temp.smaller;
                    
                    if(temp.right!=null){
                        temp=temp.right;
                    }else{
                        temp.right = new Node(newval);
                        break;
                    } 
                }else{
                    temp.smaller+=1;
                    if(temp.left!=null){
                        temp=temp.left;
                    }else{
                        temp.left = new Node(newval);
                        break;
                    }
                }
            }
            
            return count;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        
        int len = nums.length;
        
        if(len==0) return new LinkedList();
        if(len==1) return new LinkedList(Arrays.asList(0));
        
        List<Integer> res = new LinkedList();
        
        Node root = new Node(nums[len-1]);
        res.add(0);
        
        for(int i=len-2; i>=0; i--){
            res.add(0, insert(root, nums[i]));
        }
        
        return res;
    }
}
