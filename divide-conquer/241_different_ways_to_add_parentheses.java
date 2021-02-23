class Solution {
    
    ArrayList<Integer> numbers = new ArrayList();
    ArrayList<Character> ops = new ArrayList();
    
    ArrayList<Integer>[][] dp; //dp[i][j] -> list of all possible combinations for window from index 'i'  to 'j' in numbers list
    
    public int doOp(int e1, int e2, int i){//function to perform operator (defined  by index 'i')
        char sign = ops.get(i);
        
        int res = 1;
        
        switch(sign){
            case '*' : res = e1*e2; break;
            case '-' : res = e1-e2; break;
            case '+' : res = e1+e2; break;
        }
        
        return res;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        
        int num=0;
        
        //break the input string into numbers & signs
        for(char ch : input.toCharArray()){
            if(ch=='*' ||  ch == '+' || ch=='-'){
                numbers.add(num);
                ops.add(ch);
                num=0;
            }else{
                num = (num*10) + (ch-'0');
            }
        }
        
        numbers.add(num); //since 1 number is left at the end
        
        
        int n = numbers.size();
        
        dp = new ArrayList[n][n];
        
        for(int windowSize = 1; windowSize <=n; windowSize++){//windowSize from 1 to n
            
            for(int left=0; left < n-windowSize+1; left++){//start of window
                
                int right = left+windowSize - 1; //end of window
                
                if(left==right){//base case: if left=right window is of size 1, so just add number to dp[][]
                    
                    ArrayList<Integer> hs = new ArrayList();
                    hs.add(numbers.get(left));
                    dp[left][right] = hs;
                    
                }else{
                    
                    ArrayList<Integer> res = new ArrayList();//store all possible combinations for left -> right, here
                    
                    for(int i=left; i<right; i++){
                        
                        ArrayList<Integer> hs1 = dp[left][i];//all possible combination from left -> i
                        ArrayList<Integer> hs2 = dp[i+1][right];//all possible combinations from i+1 -> right
                        
                        for(int e1 : hs1){
                            for(int e2 : hs2){
                                res.add(doOp(e1, e2, i)); //combine elements according to operator, identified by index 'i'
                            }
                        } 
                    }
                    
                    dp[left][right] = res; //update dp[][] with all possible combinations
                }   
            }
        }
        
        return dp[0][n-1]; //return window 0 -> n-1
    }
}
