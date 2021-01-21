/**
My solution: 6 ms
*/
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuffer sb = new StringBuffer();
        int curr = 0;
        
        String[] sortedSources = new String[S.length()];
        String[] sortedTargets = new String[S.length()];
        
        Arrays.fill(sortedSources, "");
        Arrays.fill(sortedTargets, "");
        
        for(int i=0; i<indexes.length; i++){
            sortedSources[indexes[i]] = sources[i];
            sortedTargets[indexes[i]] = targets[i];
        }
        
        sortedSources = Arrays.stream(sortedSources).filter(s -> !s.isEmpty()).toArray(String[]::new);
        sortedTargets = Arrays.stream(sortedTargets).filter(s -> !s.isEmpty()).toArray(String[]::new);
        Arrays.sort(indexes);
        
        for(int i = 0; i < indexes.length; i++){
            int start = indexes[i];
            if(start > curr){
                sb.append(S.substring(curr, start));
                curr += (start - curr);
            }
            
            int sourceLength = sortedSources[i].length();
            if(S.substring(start, start+sourceLength).equals(sortedSources[i])){
                sb.append(sortedTargets[i]);
                curr += sourceLength;
            }
        }
        
        sb.append(S.substring(curr));
        
        System.out.println(sb.toString());
        
        return sb.toString();
    }
}

/**
LC solution

Our main motivation in these approaches is to be able to identify and handle when a given replacement operation does nothing.

In Java, the idea is to build an array match that tells us match[ix] = j whenever S[ix] is the head of a successful replacement operation j: that is, whenever S[ix:].startswith(sources[j]).

After, we build the answer using this match array. For each index ix in S, we can use match to check whether S[ix] is being replaced or not. We repeatedly either write the next character S[ix], or groups of characters targets[match[ix]], depending on the value of match[ix].




    Time Complexity: O(NQ), where N is the length of S, and we have Q replacement operations. (Our complexity could be faster with a more accurate implementation, but it isn't necessary.)

    Space Complexity: O(N), if we consider targets[i].length <= 100 as a constant bound.

*/

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }
}
