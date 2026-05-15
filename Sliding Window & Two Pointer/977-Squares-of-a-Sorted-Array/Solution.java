class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0;
        int right = len - 1;
        int idx = right;

        while(left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare){
                res[idx] = leftSquare;
                left++;
            } else {
                res[idx] = rightSquare;
                right--;
            }

            idx--;
        }

        return res;
    }
}

// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int len = nums.length;
//         for(int i = 0; i < len; i++){
//             nums[i] = nums[i] * nums[i];
//         }

//         Arrays.sort(nums);
//         return nums;
//     }
// }
