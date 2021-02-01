/**
My solution: 0 ms
*/

class Solution {
    
    public int findPeak(int[] arr, int start, int end){
        int mid = (start+end)/2;
        if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
            return mid;
        }else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]){
            return findPeak(arr, mid, end);
        }else{
            return findPeak(arr, start, mid);
        }
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        return findPeak(arr, 0, arr.length-1);
    }
}
