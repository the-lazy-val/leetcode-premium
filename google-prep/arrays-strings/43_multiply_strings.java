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


/**
Better solution:
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3051/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation

Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process! 
https://drscdn.500px.org/photo/130178585/m%3D2048/300d71f784f679d5e70fadda8ad7d68f

From the following draft, we can immediately conclude:

 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

*/

public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}

// Similar to above but easier to understand

public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        
        int[] products = new int[n1 + n2];
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        
        int carry = 0;
        
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int num : products) sb.append(num);
        
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/**
If we break it into steps, it will have the following steps. 
1. compute products from each pair of digits from num1 and num2. 
2. carry each element over. 
3. output the solution.

Things to note:

    The product of two numbers cannot exceed the sum of the two lengths. (e.g. 99 * 99 cannot be five digit)

int d1 = num1.charAt(i) - '0';
int d2 = num2.charAt(j) - '0';
products[i + j + 1] += d1 * d2;
*/

/**
Great explanation. Wanted to provide some illustration below
Smart part is realizing there is a max length of ans and directly adding sums to correct position products[i + j + 1] += d1 * d2;

num1 = "12"
num2 = "19"

 19  j
x12  i
---
 38
190  
---
228 // max length of (N1+N2+1) here


ALL loops going REVERSE

i | j | i+j+1 | product of i & j
________________________________
1 | 1 | 3     | 18
1 | 0 | 2     | 2
0 | 1 | 2     | 9
0 | 0 | 1     | 1

1st internal loop (j wala) gives
[0, 0, 2, 18]

2nd internal loop gives
[0, 1, 9, 0]

But we are adding elements already present in the indexes, so after first loop (pura i + j)

[0, 1, 11, 18]

We deal with the carry in the next loop (going reverse)

initialize carry = 0

we replace arr[i] with (arr[i] + carry)%10
carry = (arr[i] + carry)/10

      idx = 0, 1, 2, 3
products = [0, 1, 11,18] // after first loop

products = [0, 2, 2, 8] // after second loop

*/
