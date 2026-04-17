class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(seen.containsKey(num)){
                ans = Math.min(ans, i - seen.get(num));
            }

            int reverse;
            for(reverse = 0; num > 0; num /= 10){
                reverse = (reverse * 10) + (num % 10);
            }

            seen.put(reverse, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
