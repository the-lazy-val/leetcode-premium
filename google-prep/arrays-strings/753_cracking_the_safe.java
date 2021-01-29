/**
Question:
In this question you are trying to unlock the safe by putting password. The length of password is n. Everytime you enter the pasword the last n digits are matched. Since you do not know the password you want to try all combinations from k digits of length n to unlock the safe. Eg. when n = 2, k = 2, the password could be 00, 01, 10, 11. Hence your solution must contain all these combinations. When you unlock safe, last n digits are matched.
Solution is 00110
Digit entered '0' - no operation
Digit entered '0' - (you formed '00') will try to match if 00 is solution
Digit entered '1' : your solution '001' will try to match last n i.e. 01
Digit entered '1' : your solution '0011', will try to match '11'
Digit entered '0' : your solution will try to match last n i.e '10'
Hence you must come with shortest solution string containing all possible combinations

*/
