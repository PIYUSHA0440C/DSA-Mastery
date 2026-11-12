class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > nums[index - 1]) {
                incLength++;
                decLength = 1;
            } else if (nums[index] < nums[index - 1]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }
}
