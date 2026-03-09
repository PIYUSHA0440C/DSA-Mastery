class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(nums.length, nums, list, temp);
        return list;
    }
    void backtracking(int len, int[]arr, List<List<Integer>> list, List<Integer> temp){
        if(temp.size() == len){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < len; i++){
            if(temp.contains(arr[i])) continue;
            
            temp.add(arr[i]);
            backtracking(len, arr, list, temp);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
