/**
My solution: 1ms
beats 81%
*/

class Solution {
    HashMap<Character, List<Character>> hm = new HashMap();
    
    ArrayList<String> output = new ArrayList<>();
    
    public void makeString(String digits, int count, int limit, StringBuilder curr){
        if(count == limit){
            output.add(curr.toString());
        }else{
            char ch = digits.charAt(count);
        
            for(char adj : hm.get(ch)){
                curr.append(adj);
                makeString(digits, count+1, limit, curr);
                curr.setLength(curr.length() - 1); //remove last char of StringBuilder
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        hm.put('2', new ArrayList(Arrays.asList('a', 'b', 'c')));
        hm.put('3', new ArrayList(Arrays.asList('d', 'e', 'f')));
        hm.put('4', new ArrayList(Arrays.asList('g', 'h', 'i')));
        hm.put('5', new ArrayList(Arrays.asList('j', 'k', 'l')));
        hm.put('6', new ArrayList(Arrays.asList('m', 'n', 'o')));
        hm.put('7', new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        hm.put('8', new ArrayList(Arrays.asList('t', 'u', 'v')));
        hm.put('9', new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        
        makeString(digits, 0, digits.length(), new StringBuilder());
        return output;
    }
}
