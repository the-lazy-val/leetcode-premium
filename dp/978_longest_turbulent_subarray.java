class Solution {
    
    public char getRelation(int num1, int num2){
        if(num1==num2) return '=';
        if(num2<num1) return '<';
        return '>';
    }
    
    public int maxTurbulenceSize(int[] arr) {
        char prevRel = '=';
        int max=1;
        
        int i=1;
        int count=1;
        
        while(i<arr.length){
            char currRel = getRelation(arr[i-1], arr[i]);
            
            if(currRel == '='){
                count=1;
                i++;
            }else if(currRel != prevRel){
                count++;
                prevRel = currRel;
                i++;
            }else{
                count=2;
                i++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
