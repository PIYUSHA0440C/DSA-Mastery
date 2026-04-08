class Solution {
    final int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            int idx = l;

            while(idx <= r){
                long temp = nums[idx];
                nums[idx] = (int)((temp * v) % mod);
                idx += k;
            }
        }

        int ans = 0;
        for(int num: nums){
            ans ^= num;
        }

        return ans;
    }

}
