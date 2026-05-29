class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int num : nums){
            int ans = 0;
            while(num > 0){
                ans += num % 10;
                num /= 10;
            }
            res = Math.min(res, ans);
        }

        return res;
    }
}
