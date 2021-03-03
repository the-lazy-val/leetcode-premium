class Solution {
    public int minCostToMoveChips(int[] position) {
        int len = position.length;
        
        if(len <= 1) return 0;
        
        int even = 0;
        int odd = 0;
        
        for(int i=0; i<len; i++){
            if(position[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        
        return Math.min(odd, even);
    }
}
