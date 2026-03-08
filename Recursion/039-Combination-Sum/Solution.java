class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(0, target, candidates, list, current);

        return list;
    }
    void helper(int idx, int target, int[] arr, List<List<Integer>> list, List<Integer> current){
        if(idx == arr.length){
            if(target == 0){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(current);
                list.add(temp);
            }
            return;
        }

        if(arr[idx] <= target){
            current.add(arr[idx]);
            helper(idx, target - arr[idx], arr, list, current);
            current.remove(current.size() - 1);
        }

        helper(idx + 1, target, arr, list, current);
    }

}
