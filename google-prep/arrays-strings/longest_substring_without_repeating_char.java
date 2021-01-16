/**
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0

Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        
        int temp = 0;
        int max = 0;
        
        int i = 0;
        
        while(i < s.length()){
            char curr = s.charAt(i);
            
            if(hm.containsKey(curr)){
                int lastRepeatingIndex = hm.get(curr);
                temp = i - lastRepeatingIndex;
                
                /** in scala this would have been:
                hm.filter(entry -> entry.value > lastRepeatingIndex)
                
                We are removing all the entries in the map, which came before the last repaeating character
                e.g: In case of "abba"
                we encounter first repeating character at index = 1
                but, now we also cannot consider any other char before it
                so we remove all entries before index = 1
                
                e.g: In case of "abcdebr"
                Here also first repeating character is at index = 1
                So we discard hashMap entries of "ab" and NOT "cde"
                */
                hm = hm.entrySet().stream()
                    .filter(entry -> entry.getValue() > lastRepeatingIndex)
                    .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
                
                hm.put(curr, i);
            }else{
                hm.put(curr, i);
                temp++;
            }
            max = Math.max(max, temp);
            i++;
        }
        return max;
    }
}


/** LC solutions:
The above solution is slow because of the "filter" operation.
Runtime: 158 ms

Essentially, in filter, we are removing all the characters before the repeating character.

We can do this filtering in another way: keep a sliding window, and just reduce the window size 
(by updating the start of the window to the character next to the repeating char)

i -> denotes start of the window (or start of the string with non-repeating digit)
j -> end of the window (we use this as iterator as well)

max -> max length so far

j-i+1 -> length of the window (i.e. current length of the non-repeatinf string)

We maintain a HashMap<Character, Integer>

here, whenever we encounter a character (through iterator j), we insert (c -> (j+1))

So, in a way, we are storing the index, just after the character, so if we need to update i in window, we can directly reference this.

For updating the window when we detect repetition, we do:

i = Math.max(hm.get(s.charAt(j)) , i)

because, if "i" is already ahead of the last occurence of character, we do not want to move back "i"



    Time complexity : O(n)O(n)O(n). Index jjj will iterate nnn times.

    Space complexity (HashMap) : O(min(m,n))O(min(m, n))O(min(m,n)). Same as the previous approach.

    Space complexity (Table): O(m)O(m)O(m). mmm is the size of the charset.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        
        int max = 0;
        
        int i =0;
        int j=0;
        
        while(j < s.length()){
            char curr = s.charAt(j);
            
            if(hm.containsKey(curr)){
                i = Math.max(hm.get(curr), i);
            }
            
            max = Math.max(max, j-i+1);
            hm.put(curr, j+1);
            j++;
        }
        
        return max;
    }
}
