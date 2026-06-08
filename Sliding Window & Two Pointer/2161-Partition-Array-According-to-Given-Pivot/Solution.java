class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] ans = new int[len];
        int i = 0, j = len - 1;
        int left = 0, right = len - 1;

        while(i < len && j >= 0){
            if(nums[i] < pivot){
                ans[left++] = nums[i];
            }
            if(nums[j] > pivot){
                ans[right--] = nums[j];
            }

            i++;
            j--;
        }

        for(int k = left; k <= right; k++){
            ans[k] = pivot;
        }

        return ans;
    }
}


// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         List<Integer> left = new ArrayList<>();   
//         int center = 0;   
//         List<Integer> right = new ArrayList<>();   

//         for(int num : nums){
//             if(num < pivot) left.add(num);
//             else if(num == pivot) center++;
//             else right.add(num);
//         }
        
//         int idx = 0;
//         while(idx < left.size()){
//             nums[idx] = left.get(idx++);
//         }

//         while(center-- > 0){
//             nums[idx++] = pivot;
//         }

//         for(int i = 0; idx < nums.length; i++){
//             nums[idx++] = right.get(i);
//         }

//         return nums;
//     }
// }
