/**
Question:
In this question you are trying to unlock the safe by putting password. The length of password is n. Everytime you enter the pasword the last n digits are matched. Since you do not know the password you want to try all combinations from k digits of length n to unlock the safe. Eg. when n = 2, k = 2, the password could be 00, 01, 10, 11. Hence your solution must contain all these combinations. When you unlock safe, last n digits are matched.
Solution is 00110
Digit entered '0' - no operation
Digit entered '0' - (you formed '00') will try to match if 00 is solution
Digit entered '1' : your solution '001' will try to match last n i.e. 01
Digit entered '1' : your solution '0011', will try to match '11'
Digit entered '0' : your solution will try to match last n i.e '10'
Hence you must come with shortest solution string containing all possible combinations

*/

// https://www.youtube.com/watch?v=6VSWohXUZMQ


class Solution {
    HashSet<String> visited;
    StringBuilder result;
    
    
    public void dfs(String node, int k){ //if n=3, start="00" then we append all possible k values
        for(int i=0; i<k; i++){
            String temp = node + i;
            if(! visited.contains(temp)){
                visited.add(temp);
                dfs(temp.substring(1), k); //now take last n-1 chars, and treat it as node is the dfs function
                
                result.append(i);
            }
        }
    }
    
    public String crackSafe(int n, int k) {
        if(n==1 && k==1){
            return "0";
        }
        
        visited = new HashSet<>();
        result = new StringBuilder();
        
       
        String start = "0".repeat(n-1); // so if n=3, start = "00"
        
        dfs(start, k);
        
        result.append(start);
        
        return result.toString();
    }
}
