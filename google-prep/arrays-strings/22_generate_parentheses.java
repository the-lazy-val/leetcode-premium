class Solution {
    ArrayList<String> output = new ArrayList<>();
    
    public void helper(int open, int close, int limit, String curr){
        if(curr.length() == limit*2){
            output.add(curr);
        }else{
                if(open < limit)
                    helper(open+1, close, limit, curr +'(');
                if(close < open)
                    helper(open, close+1, limit, curr + ')');
        }
    }
    
    public List<String> generateParenthesis(int n) {
        helper(0, 0, n, "");
        return output;
    }
}
