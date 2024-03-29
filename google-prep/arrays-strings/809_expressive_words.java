/**
My solution: 11 ms
beats: 9 %
*/
class Solution {
    
    public String minimise(String s){
        StringBuilder res = new StringBuilder();
        
        int count = 1;
        char prev = s.charAt(0);
        
        for(char c : s.substring(1).toCharArray()){
            if(c == prev){
                count++;
            }else{
                
                if(count >= 10){
                    res.append(prev + Integer.toString(count));
                }else{
                    res.append(prev + "0" + Integer.toString(count));
                }
                
                prev = c;
                count = 1;
            }
        }
        
        if(count >= 10){
            res.append(prev + Integer.toString(count));
        }else{
            res.append(prev + "0" + Integer.toString(count));
        }
        
        return res.toString();
    }
    
    public boolean isStrechy(String minS, String minWord){
        for(int i=0; i<=minS.length()-3; i+=3){
            if(minS.charAt(i) != minWord.charAt(i)){
                return false;
            }
            
            int minSCount = Integer.parseInt(minS.substring(i+1, i+3));
            int minWordCount = Integer.parseInt(minWord.substring(i+1, i+3));
            
            if(minSCount != minWordCount){
                if(minSCount >= 3 && minWordCount < minSCount){
                    
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        if(S.length() == 0){
            return count;
        }
        
        String minS = minimise(S);
        
        for(String word: words){
            if(word.length() == 0 && S.length() == 0){
                count++;
            }else{
                String minWord = minimise(word);
                if(minS.length() == minWord.length()){
                    boolean check = isStrechy(minS, minWord);
                    if(check){
                        count++;
                    }
                }
            }
        }
        
        
        return count;
    }
}

/**
Better approach (LC solution)

Run Length Encoding

For some word, write the head character of every group, and the count of that group. For example, for "abbcccddddaaaaa", we'll write the "key" of "abcda", and the "count" [1,2,3,4,5].

Let's see if a word is stretchy. Evidently, it needs to have the same key as S.

Now, let's say we have individual counts c1 = S.count[i] and c2 = word.count[i].

    If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters.

    If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.

    Else, if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match.
    



    Time Complexity: O(QK), where Q is the length of words (at least 1), and K is the maximum length of a word.

    Space Complexity: O(K).

*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}

/**
Two - pointer approach

We have two pointers, use i to scan S, and use j to scan each word in words.
Firstly, for S and word, we can calculate the length of the susbtrings which contains the repeated letters of the letter currently pointed by the two pointers, and get len1 and len2.

The two letters currently pointed by the two pointers must be equal, otherwise the word is not stretchy, we return false. Then, if we find that len1 is smaller than 3, it means the letter cannot be extended, so len1 must equals to len2, otherwise this word is not stretchy. In the other case, if len1 equals to or larger than 3, we must have len1 equals to or larger than len2, otherwise there are not enough letters in S to match the letters in word.

Finally, if the word is stretchy, we need to guarantee that both of the two pointers has scanned the whole string.
*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        if (S == null || words == null) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (stretchy(S, word)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean stretchy(String S, String word) {
        if (word == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(S, i);
                int len2 = getRepeatedLength(word, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }
    
    public int getRepeatedLength(String str, int i) {
        int j = i;
        while (j < str.length() && str.charAt(j) == str.charAt(i)) {
            j++;
        }
        return j - i;
    }
}
