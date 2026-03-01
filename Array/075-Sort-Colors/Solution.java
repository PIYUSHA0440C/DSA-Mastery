class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            int middle = nums[mid];
            if(middle == 0){
                int temp = nums[low];
                nums[low] = middle;
                nums[mid] = temp;
                low++;
                mid++;
            } else if(middle == 1){
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = middle;
                high--;
            }
        }
    }
}

