class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correct = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        // Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         HashSet<Integer> value = new HashSet<>();
//         int length = nums.length;
//         for(int i = 0; i < length; i++){
//             value.add(nums[i]);
//         }
//         int i = 1, end = Integer.MAX_VALUE;
//         while(i<=end){
//             if(!value.contains(i)) return i;
//             i++;
//         }
//         return end;
//     }
// }
