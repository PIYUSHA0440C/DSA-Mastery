class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int rightSum = 0;
        int leftSum = 0;
        int answer[] = new int[n];

        for(int num : nums) rightSum += num;

        for(int i = 0; i < n; i++){
            rightSum -= nums[i];

            answer[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return answer;
    }
}

