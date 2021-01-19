/**
My solution: runtime 5 ms
*/
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    String str = "";
    
    public int read(char[] buf, int n) {
        if(n <= 0){
            return 0;
        }else{
            
            int strlen = str.length();
            
            if(n < strlen){
                int i =0;
                for(i =0; i<n; i++){
                    buf[i] = str.charAt(i);
                }
                str = str.substring(i);
                return n;
                
            }else if(n == strlen){
                
                for(int i =0; i<n; i++){
                    buf[i] = str.charAt(i);
                }
                str = "";
                return n;
                
            }
            else{
                int count = 0;
                int temp = n;
                
                if(strlen > 0){
                    char[] tempbuf = new char[strlen];
                    int len = read(tempbuf, strlen);
                    System.arraycopy(tempbuf, 0, buf, count, len);
                    count += len;
                    temp -= len;
                }
                
                int fourLengths = temp/4;
                int left = temp%4;
                
                for(int i=0; i<fourLengths; i++){
                    char[] tempbuf = new char[4];
                    int len = read4(tempbuf);
                    System.arraycopy(tempbuf, 0, buf, count, len);
                    count+=len;
                }
                
                if(left > 0){
                    char[] tempbuf = new char[4];
                    int len = read4(tempbuf);
                    
                    if(len <= left){
                        System.arraycopy(tempbuf, 0, buf, count, len);
                        count += len;
                    }else{
                        System.arraycopy(tempbuf, 0, buf, count, left);
                        count += left;
                        for(int x=left; x<len; x++){
                            str += tempbuf[x];
                        }
                    }
                }
                
                return count;
                
            }
        }
    }
}


/**
Better solution
*/

/**
     * @param bufCache: store reading results when we call read4() every time. Once it is empty, call read4() again
     * @param bufPtr: globe variable that points next reading position in bufCache. It should always < 4
     * @param bufCount: count number of elements in bufCache. Usually equals to 4, but may less than 4 when reach end of input
     * */
    char[] bufCache = new char[4];
    int bufPtr = 0;
    int bufCount = 0;

    public int read(char[] buf, int n) {
        int nIndex = 0;

        // fill out every position until reach n
        while (nIndex < n) {
            // only if bufPtr does not reach the end of bufCache array, we can assign value from bufCache to final buf array
            if (bufPtr < bufCount) {
                buf[nIndex++] = bufCache[bufPtr++];
            }

            // if we already used all characters from bufCache, we need to read new characters by calling read4()
            // and then fill the bufCache
            else {
                bufCount = read4(bufCache);
                bufPtr = 0;

                // if no more characters we can read, we should break the entire loop and return 0
                if (bufCount == 0) {
                    break;
                }
            }
        }
        return nIndex;
    }    
