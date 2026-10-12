class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 2) return nums[0];

        int sum = 0;
        for(int i = nums.length - 2; i >= 0; i -= 2){
            sum += nums[i];
        }

        return sum;
    }
}
