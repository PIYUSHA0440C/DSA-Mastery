class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generate(combinations, "", 0, 0, n);

        return combinations;
    }

    private void generate(List<String> combinations, String str, int open, int close, int max) {
        if(close == max) {
            combinations.add(str);
            return;
        }

        if(open < max) generate(combinations, str + "(", open + 1, close, max);
        if(close < open) generate(combinations, str + ")", open, close + 1, max);
    }
}

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> list = new ArrayList<>();
//         helper(list, "", 0, 0, n);
//         return list;
//     }
    
//     void helper(List<String> list, String s, int open, int close, int max){
//         if(s.length() == max * 2){
//             list.add(s);
//             return;
//         }
        
//         if(open < max){
//             helper(list, s + "(", open + 1, close, max);
//         }
//         if(close < open){
//             helper(list, s + ")", open, close + 1, max);
//         }
//     }
// }
