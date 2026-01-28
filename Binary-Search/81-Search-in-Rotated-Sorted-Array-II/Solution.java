class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1; // Correct initialization for the end index

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: if start, mid, and end are the same, skip start and end
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Check if the left side is sorted
            else if (nums[start] <= nums[mid]) {
                // Check if target is in the left sorted portion
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Otherwise, the right side is sorted
            else {
                // Check if target is in the right sorted portion
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
