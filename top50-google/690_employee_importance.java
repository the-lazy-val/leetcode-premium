/**
beats 99%
*/
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int total = 0;
    HashMap<Integer, Employee> hm;
    
    public int helper(int id){
        Employee curr = hm.get(id);
        int sum = curr.importance;
        for(int i : curr.subordinates){
            sum+= helper(i);
        }
        return sum;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        hm = new HashMap<>();
        for(Employee e : employees){
            hm.put(e.id, e);
        }
        
        return helper(id);
    }
}
