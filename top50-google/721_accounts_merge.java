/**
Using Union Find
(can also be done via DFS similar to number of islands)

*/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> mailToRoot = new HashMap<>();
        HashMap<String, String> mailToOwner = new HashMap<>();
        HashMap<String, HashSet<String>> allMailsToAbsRoot = new HashMap<>();
        
        /**
        First loop: make every email its own root
            johnsmith@mail.com->johnsmith@mail.com
            john00@mail.com->john00@mail.com
            johnnybravo@mail.com->johnnybravo@mail.com
            johnsmith@mail.com->johnsmith@mail.com
            john_newyork@mail.com->john_newyork@mail.com
            mary@mail.com->mary@mail.com
        */
        
        for(List<String> acc : accounts){
            for(int i=1; i<acc.size(); i++){
                mailToRoot.put(acc.get(i), acc.get(i)); //initially every email is its own root
                mailToOwner.put(acc.get(i), acc.get(0)); 
            }
        }
        
        /**
        Second loop: link all emails in an account to the first email in the array (absolute root)
            johnsmith@mail.com->johnsmith@mail.com
            john00@mail.com->johnsmith@mail.com
            johnnybravo@mail.com->johnnybravo@mail.com
            johnsmith@mail.com->johnsmith@mail.com
            john_newyork@mail.com->johnsmith@mail.com
            mary@mail.com->mary@mail.com
        */
        
        for(List<String> acc : accounts){
            String absoluteRoot = find(acc.get(1), mailToRoot); //get absolute root of 1st email
            
            for(int i=2; i<acc.size(); i++){
                String rootOfAccountI = find(acc.get(i), mailToRoot);
                //set absoluteRoot as root of all other emails in that account
                mailToRoot.put(rootOfAccountI, absoluteRoot);
            }
        }
        
        /**
        Third loop: absolteRoot -> list of children emails
        
            johnsmith@mail.com->{johnsmith@mail.com,john00@mail.com,john_newyork@mail.com}
            johnnybravo@mail.com->{johnnybravo@mail.com}
            mary@mail.com->{mary@mail.com}
        */
        
        for(List<String> acc : accounts){
            for(int i=1; i<acc.size(); i++){
                String thisEmail = acc.get(i);
                String absoluteRoot = find(thisEmail, mailToRoot);
                // mapping to absoluteRoot to all its children
                allMailsToAbsRoot.computeIfAbsent(absoluteRoot, x -> new HashSet()).add(thisEmail);
            }
        }
        
        List<List<String>> output = new ArrayList();
        
        for(HashSet<String> e : allMailsToAbsRoot.values()){
            ArrayList<String> temp = new ArrayList<>();
            temp.addAll(e);
            Collections.sort(temp);
            temp.add(0, mailToOwner.get(temp.get(0)));
            output.add(temp);
        }
            
        return output;
        
    }
    
    //find absolute root
    public String find(String email, HashMap<String, String> mailToRoot){
        String parent = mailToRoot.get(email);
        
        if(parent.equals(email)) 
            return email;
        else
            return find(parent, mailToRoot);
    }
}
