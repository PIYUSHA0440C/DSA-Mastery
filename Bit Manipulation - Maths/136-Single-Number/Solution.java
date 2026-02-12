class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int ans = 0;
        for(int i : nums){
            ans ^= i;
        }
        return ans;
    }
}
