class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(current);
        }
        return nge;
    }
}

// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] ans = new int[nums.length];
//         Arrays.fill(ans, -1);

//         for(int i = 0; i < nums.length; i++){
//             ans[i] = nextGreater(nums, i);
//         }

//         return ans;
//     }

//     private int nextGreater(int[] nums, int idx){
//         for(int i = idx + 1; i < nums.length; i++){
//             if(nums[i] > nums[idx]) return nums[i];
//         }

//         for(int i = 0; i < idx; i++){
//             if(nums[i] > nums[idx]) return nums[i];
//         }


//         return -1;
//     }
// }
