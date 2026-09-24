class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum;
        int currentSum = 0;

        int left = 0;
        int right = 0;

        while(right < k){
            currentSum += nums[right++];
        }
        
        maxSum = currentSum;

        while(right < nums.length){
            currentSum -= nums[left++];
            currentSum += nums[right++];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }
}
