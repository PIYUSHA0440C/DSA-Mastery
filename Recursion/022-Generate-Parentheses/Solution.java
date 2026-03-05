class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
    
    void helper(List<String> list, String s, int open, int close, int max){
        if(s.length() == max * 2){
            list.add(s);
            return;
        }
        
        if(open < max){
            helper(list, s + "(", open + 1, close, max);
        }
        if(close < open){
            helper(list, s + ")", open, close + 1, max);
        }
    }
}
