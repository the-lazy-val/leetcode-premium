//https://leetcode.com/problems/number-of-islands-ii/discuss/995970/O(L)-Time-and-O(L)-Space-Java-solution
class Solution {
    
    HashMap<Integer, Integer> dsu = new HashMap();
    int count=0;
    
    public int find(int index) {
        
        if(!dsu.containsKey(index)) return -1;
        
        if(index != dsu.get(index)){
            dsu.put(index, find(dsu.get(index))); //path compression
        }
        
        return dsu.get(index);
    }
    
    public boolean union(int oldPoint, int newPoint){
        int oldRoot = find(oldPoint);
        int newRoot = find(newPoint);
        
        if(oldRoot==-1 || newRoot==-1) return false;
        
        if(oldRoot!=newRoot){
            dsu.put(oldRoot, newRoot);
            count--;
            return true;
        }
        return false;
    }
    
    public int getIndex(int m, int n, int x, int y){
        return (n*x)+y; //m*x + y was giving wrong answer
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        
        List<Integer> res = new LinkedList();
        
        for(int[] pos : positions){
            int x= pos[0];
            int y= pos[1];
            
            int index = getIndex(m,n,x,y);
            
            if(dsu.containsKey(index)){
                res.add(count);
            }else{
                dsu.put(index, index);
                count++;
                
                //top
                if(x-1 >= 0){
                    int topIndex = getIndex(m, n, x-1, y);
                    union(index, topIndex);
                }
                
                //right
                if(y+1 < n){
                    int rightIndex = getIndex(m, n, x, y+1);
                    union(index, rightIndex);
                }
                
                //bottom
                if(x+1 < m){
                    int bottomIndex = getIndex(m, n, x+1, y);
                    union(index, bottomIndex);
                }
                
                //left
                if(y-1 >=0){
                    int leftIndex = getIndex(m, n, x, y-1);
                    union(index, leftIndex);
                }
                
                res.add(count); //repeated step from line 47, but ok.. good for understanding
            } 
        }
        
        return res;
    }
}
