class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > max) max = num;
            sum += num;
        }

        return nums.length * max - sum;
    }
}
