class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);

        return ans;

        // int firstOccurence = firstOccurence(nums, target);
        // int lastOccurence = lastOccurence(nums, target);

        // return new int[]{firstOccurence, lastOccurence};

    }

    int search(int[] nums, int target, boolean isFirstOccurence){
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                // Potential ans
                ans = mid;
                if(isFirstOccurence){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    
    // int firstOccurence(int[] nums, int target){
    //     int len = nums.length;
    //     int start = 0;
    //     int end = len - 1;
    //     int firstOccurence = -1;
    //     while(start <= end){
    //         int mid = start + (end - start) / 2;
    //         if(target < nums[mid]){
    //             end = mid - 1;
    //         } else if (target > nums[mid]){
    //             start = mid + 1;
    //         } else {
    //             firstOccurence = mid;
    //             end = mid - 1;
    //         }

    //     }

    //     return firstOccurence;
    // }

    // int lastOccurence(int[] nums, int target){
    //     int len = nums.length;
    //     int start = 0;
    //     int end = len - 1;
    //     int lastOccurence = -1;
    //     while (start<=end){
    //         int mid = start + (end - start) / 2;
    //         if(target < nums[mid]){
    //             end = mid - 1;
    //         } else if (target > nums[mid]){
    //             start = mid + 1;
    //         } else {
    //             lastOccurence = mid;
    //             start = mid + 1;
    //         }
    //     }
    //     return lastOccurence;
    // }

}
