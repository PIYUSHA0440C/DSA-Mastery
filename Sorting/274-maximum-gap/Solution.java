class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        Arrays.sort(nums);
        long maxValue = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] > maxValue){
                maxValue = nums[i] - nums[i - 1];
            }
        }

        return (int)maxValue;
    }
}
