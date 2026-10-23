class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (-nums[low] == nums[high]) return nums[high];

            else if (-nums[low] > nums[high]) low++;
            else high--;
        }

        return -1;
    }
}

