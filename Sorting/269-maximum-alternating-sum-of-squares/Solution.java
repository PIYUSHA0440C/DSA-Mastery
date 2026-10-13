class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long score = 0;

        for(int i = 0; i < len; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        for(int i = len / 2; i < len; i++){
            score += nums[i];
        }

        for(int i = 0; i < len / 2; i++){
            score -= nums[i];
        }

        return score;
    }
}
