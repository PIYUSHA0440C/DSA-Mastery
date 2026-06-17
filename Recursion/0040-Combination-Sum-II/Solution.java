class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);

        helper(0, 0, target, candidates, list, curr);
        return list;
    }
    void helper(int idx, int sum, int target, int[] arr, List<List<Integer>> list, List<Integer> curr){
        if(sum >= target){
            if(sum == target && !list.contains(curr)){
                list.add(new ArrayList(curr));
            }

            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            curr.add(arr[i]);
            helper(i + 1, sum + arr[i], target, arr, list, curr);
            curr.remove(curr.size() - 1);
        }
        return;
    }
}
