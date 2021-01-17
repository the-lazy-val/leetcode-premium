/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.

*/

//My Solution: 68 ms
class Solution {
    
    public void addition(String[] nums){
        int carry = 0;
        String num1 = nums[0];
        String num2 = nums[1];
        
        int add1 = 0;
        int add2 = 0;
        int added = 0;
        
        int i=0;
        int j=0;
        
        StringBuilder nsb = new StringBuilder();
        
        for(i=num1.length()-1,j=num2.length()-1; i>=0; i--,j--){
            add1 = num1.charAt(i) - '0';
            add2 = num2.charAt(j) - '0';
            
            added = add1 + add2 + carry;
            carry = added / 10;
            nsb.append(Integer.toString(added % 10));
        }
        
        for(int k=j; k>=0; k--){
            add1= num2.charAt(k) - '0';
            
            added = add1 + carry;
            carry = added / 10;
            
            nsb.append(Integer.toString(added % 10));
        }
        
        if(carry > 0){
            nsb.append(Integer.toString(carry));
        }
        
        nums[0] = nsb.reverse().toString();
    }
    
    public String checkZero(String str){
        boolean flag = true;
        for(int i=0; i< str.length(); i++){
            boolean temp = (str.charAt(i) - '0') == 0;
            flag = flag && temp;
        }
        if(flag){
            return "0";
        }else{
            return str;
        }
    }
    
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        if(len2 < len1){
            int temp = len1;
            len1=len2;
            len2=temp;
            
            String tempNum = num1;
            num1 = num2;
            num2 = tempNum;
        }
        
        String[] adds = new String[2];
        
        int carry = 0;
        
        int i = 0;
        int j = 0;
        
        int multipliedBy = 0;
        int multiplied = 0;
        
        for(i=len1-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            multipliedBy = num1.charAt(i) - '0';
            
            for(j=len2-1; j>=0; j--){
                multiplied = multipliedBy * (num2.charAt(j) - '0');
                multiplied += carry;
                
                carry = multiplied / 10;
                sb.append(Integer.toString(multiplied % 10));
            }
            if(carry > 0){
                sb.append(Integer.toString(carry));
            }
            carry = 0;
            
            StringBuilder reverse = sb.reverse();
            
            for(int k=len1-1; k>i;k--){
                reverse.append('0');
            }
            if(i == len1-1){
                System.out.println("adding first: "+reverse.toString());
                adds[0] = reverse.toString();
            }else{
                System.out.println("adding new: "+reverse.toString());
                adds[1] = reverse.toString();
                addition(adds);
            }
        }
        
        return checkZero(adds[0]);
    }
}
