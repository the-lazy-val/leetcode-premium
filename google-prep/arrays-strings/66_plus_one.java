/**
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
*/

//My solution: optimal
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        
        for(int i = len-1; i>=0;i--){
            int added = digits[i] + carry;
            digits[i] = added % 10;
            carry = added / 10;
        }
        
        if(carry > 0){
            int[] res = new int[len+1];
            System.arraycopy(digits, 0, res, 1, len);
            res[0] = carry;
            return res;
        }else{
            return digits;
        }
    }
}
