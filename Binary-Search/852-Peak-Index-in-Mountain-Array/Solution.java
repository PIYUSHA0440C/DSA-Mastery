class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){ 
            //for condition start<=end use a else condition also that is return end to avoid error overflow
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                end = mid; 
            }
            if (arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }
        }
        return end;
    }
}
