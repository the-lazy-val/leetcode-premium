class Solution {
    
    // https://leetcode.com/problems/beautiful-array/discuss/694087/Divide-and-Conquer
    
    public ArrayList<Integer> generate(ArrayList<Integer> li){
        
        int size = li.size();
        
        if(size <= 1) return li;
        
        ArrayList<Integer> odd = new ArrayList();
        ArrayList<Integer> even = new ArrayList();
        
        for(int i=0; i<size; i++){
            if(i%2 == 0){
                even.add(li.get(i));
            }else{
                odd.add(li.get(i));
            }
        }
        
        ArrayList<Integer> genOdd = generate(odd);
        ArrayList<Integer> genEven = generate(even);
        genOdd.addAll(genEven);
        
        return genOdd;
    }
    
    public int[] beautifulArray(int N) {
        ArrayList<Integer> li = new ArrayList();
        
        for(int i=0; i<N; i++){
            li.add(i+1);
        }
        
        if(N==1 || N==2) {
            int[] output = li.stream().mapToInt(i -> i).toArray();
            return output;
        }
        
        ArrayList<Integer> res = generate(li);
        int[] output = res.stream().mapToInt(i -> i).toArray();
        return output;
    }
}
