/**
My solution
 0 ms
 beats 100 %
 */
 
 class Solution {
    
    StringBuilder sb = new StringBuilder();
    
    public void navigate(int startx, int starty, int endx, int endy){
        if(startx < endx){
            sb.append("D".repeat(endx-startx));
        }else if(startx > endx){
            sb.append("U".repeat(startx-endx));
        }
        
        if(starty < endy){
            sb.append("R".repeat(endy-starty));
        }else if(starty > endy){
            sb.append("L".repeat(starty-endy));
        }
    }
    
    public String alphabetBoardPath(String target) {
        
        int startx = 0;
        int starty = 0;
        
        for(char c : target.toCharArray()){
            
            int endx = (c - 'a') / 5;
            int endy = (c - 'a') % 5;
            
            if(startx == endx && starty == endy){
                sb.append('!');
            }else if(c == 'z'){
                navigate(startx, starty, 4, 0);
                sb.append("D!");
                startx = 5;
                starty = 0;
            }else{
                navigate(startx, starty, endx, endy);
                sb.append('!');
                startx = endx;
                starty = endy;
            }
        }
        
        return sb.toString();
    }
}
