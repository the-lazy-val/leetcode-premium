/**
My solution: 11 ms
beats 16 %

added time complexity of sorting: O(N log N)
*/

class Solution {
    ArrayList<int[]> res = new ArrayList<>();
    
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0]-i2[0]);
        
        int len = intervals.length;
        
        int start = 0;
        int curr = 0;
        res.add(intervals[0]);
        
        while(curr < len){
            int[] temp = res.get(start);
            int[] current = intervals[curr];
            
            if(temp[0]<=current[0] && current[0]<=temp[1] &&
                     temp[0]<=current[1] && current[1]<=temp[1]){
                res.set(start, temp);
            }else if(temp[0] <= current[0] && current[0] <= temp[1] && current[1] >= temp[1]){
                res.set(start, new int[]{temp[0], current[1]});
            }else{
                start++;
                res.add(start, current);
            }
            curr++;
        }
        
        
        int[][] arr = new int[res.size()][2];
        res.toArray(arr);
        return arr;
    }
}
