class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtracking(1, n, k, list, cur);
        return list;
    }

    void backtracking(int s, int n, int k, List<List<Integer>> list, List<Integer> cur){
        if(cur.size() == k){
            list.add(new ArrayList<>(cur));
            return;
        }

        for(int i = s; i <= n; i++){
            cur.add(i);
            backtracking(i + 1, n, k, list, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
