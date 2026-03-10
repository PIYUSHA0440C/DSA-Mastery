class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(1, k, n, list, curr);
        return list;
    }
    void helper(int start, int k, int target, List<List<Integer>> list, List<Integer> curr){
        if(curr.size() == k){
            if(target == 0){
                list.add(new ArrayList<>(curr));
            }
            return;
        }


        for(int i = start; i <= 9; i++){
            curr.add(i);
            helper(i + 1, k , target - i, list, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
