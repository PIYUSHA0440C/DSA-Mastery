class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
         int index1 = m-1;
         int index2 = n-1;
         int i = nums1.length - 1;
         while(index2 >= 0){
            if(index1 >= 0 && nums1[index1] > nums2[index2]){
                nums1[i] = nums1[index1];
                index1--;
            } else {
                nums1[i] = nums2[index2];
                index2--;
            }
            i--;
         }
    }
}
