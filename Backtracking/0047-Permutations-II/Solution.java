class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        backtracking(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    void backtracking(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);
            backtracking(nums, list, temp, used);

            used[i] = false;
            temp.remove(temp.size() - 1); 
        }
    }
}
