class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] nge = new int[nums2.length];
        int[] ans = new int[nums1.length];
        Stack<Integer> st = new Stack<>();

        nge[n-1] = -1;
        st.push(nums2[n-1]);

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()) nge[i] = -1;
            else nge[i] = st.peek();
            st.push(nums2[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums2[i],nge[i]);
        }

        for(int i = 0; i < m; i++){
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }else{
                ans[i] = -1;
            }
        }
        return ans;
    }
}
