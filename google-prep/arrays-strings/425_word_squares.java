/**
My solution: works but Time Limit exceeded on large inputs
*/

class Solution {
    
    List<List<String>> output;
    HashMap<Character, ArrayList<String>> hm;
    
    public boolean checkAtIndex(String[] arr, int index){
        String init = arr[index];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i].charAt(index));
        }
        
        String target = sb.toString();
        
        return target.equals(init);
    }
    
    public void checkSquare(String[] arr){
        
        int len = arr.length;
        boolean res = true;
        for(int i=0; i<len; i++){
            boolean temp = checkAtIndex(arr, i);
            if(!temp){
                res = false;
                break;
            }
        }
        
        if(res){
            output.add(new ArrayList(Arrays.asList(arr)));
        }
        
    }
    
    public void makeSquare(String[] arr, int index, int len){
        if(index == len){
            checkSquare(arr);
        }else{
            char key = arr[0].charAt(index);
            if(hm.containsKey(key)){
                for(String p : hm.get(key)){
                    arr[index] = p;
                    makeSquare(arr, index+1, len);
                }
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        output = new ArrayList();
        hm = new HashMap();
        
        int len = words[0].length();
        
        for(String w : words){
            char c = w.charAt(0);
            if(hm.containsKey(c)){
                hm.get(c).add(w);
            }else{
                hm.put(c, new ArrayList(Arrays.asList(w)));
            }
        }
        
        for(String w: words){
            String[] arr = new String[len];
            arr[0] = w;
            makeSquare(arr, 1, len);
        }
        
        return output;
    }
}
