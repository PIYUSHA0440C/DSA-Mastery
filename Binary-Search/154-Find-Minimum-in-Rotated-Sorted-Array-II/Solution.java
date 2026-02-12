class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int pivot = pivot(nums, start, end);
        if(pivot == -1) return nums[0];
        return nums[pivot];
    }

    int pivot(int[] nums, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            else if(mid > start && nums[mid] < nums[mid - 1]){
                return mid;
            }
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) {
                    return start + 1; // return the min, not the max
                }
                start++;

                if (end > start && nums[end] < nums[end - 1]) {
                    return end; // return the min, not the max
                }
                end--;
            }
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
