class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int index = nums.length - 1;
        int count = 2;

        int ans = nums[index];

        if(index < 2) return ans;

        while(index >= 0 && count > 0){
            if(nums[index] != ans){
                ans = nums[index];
                count--;
            }

            index--;
        }

        if(count > 0) return nums[nums.length - 1];
        
        return ans;
    }
}
