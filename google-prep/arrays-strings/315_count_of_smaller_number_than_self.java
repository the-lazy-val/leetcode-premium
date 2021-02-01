/**
BST solution

insertion from end
as you insert maintain leftCount

recursive insert
if you go right, return currentCount + root.leftCount + 1

Time limit exceeds on skewed BST
*/

class Node{
    int val;
    Node left;
    Node right;
    int leftCount;
    
    public Node(int v){
        val = v;
        left=null;
        right=null;
        leftCount=0;
    }
}

class Solution {
    
    public int insert(Node root, int num, int count){
        
        if(num <= root.val){
            root.leftCount+=1;
            if(root.left==null){
                root.left = new Node(num);
                return count;
            }else{
                return insert(root.left, num, count);
            }
        }else{
            if(root.right==null){
                root.right = new Node(num);
                return count+1+root.leftCount;
            }else{
                return insert(root.right, num, count+1+root.leftCount);
            }
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Node root = null;
        
        int[] res = new int[nums.length];
        
        for(int i=nums.length-1; i>=0; i--){
            if(root == null){
                root = new Node(nums[i]);
                res[i] = 0;
            }else{
                Node temp = root;
                res[i] = insert(temp, nums[i], 0);
            }
        }
        
        LinkedList<Integer> li = new LinkedList<>();
        for(int r : res){
            li.add(r);
        }
        
        return li;
    }
}
