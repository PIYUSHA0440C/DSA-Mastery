class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);
        subset(nums, 0, len, list, curr);
        return list;
    }
    void subset(int[] nums, int start, int end, List<List<Integer>> list, List<Integer> curr){
        list.add(new ArrayList<>(curr));

        for(int i = start; i < end; i++){
            if(i > start && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            subset(nums, i + 1, end, list, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
