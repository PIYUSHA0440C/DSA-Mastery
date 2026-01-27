class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = pivot(nums, start, end);
        if(pivot != -1) return nums[pivot];
        return nums[0];
    }
    int pivot(int[] nums, int start, int end){
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid+1]){
                return mid+1;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid;
            }
            if(nums[mid] > nums[start]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
