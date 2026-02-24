class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len == 3){
             return nums[0] * nums[1] * nums[len - 1];
        }

        Arrays.sort(nums);

        int a = nums[0] * nums[1] * nums[len - 1];
        int b = nums[len - 1] * nums[len - 2] * nums[len - 3];

        if (a > b) return a;
        return b;
    }
}
