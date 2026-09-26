class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int operations = 0;

        while(left < right){
            int currentSum = nums[left] + nums[right];

            if (currentSum == k){
                operations++;
                left++;
                right--;
            } else if (currentSum < k){
                left++;
            } else {
                right--;
            }
        }

        return operations;
    }
}
