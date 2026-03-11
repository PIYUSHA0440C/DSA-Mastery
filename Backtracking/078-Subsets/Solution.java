class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, nums.length, nums, list, temp);
        return list;
    }

    void helper(int s, int len, int[] nums, List<List<Integer>> list, List<Integer> temp){
        list.add(new ArrayList<>(temp));

        for(int i = s; i < len; i++){
            temp.add(nums[i]);
            helper(i + 1, len, nums, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
