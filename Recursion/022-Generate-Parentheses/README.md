# 22. Generate Parentheses (Medium)

## 📝 Problem Statement
Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## 💡 Intuition & Approach
To generate only valid (well-formed) parentheses, we use **Backtracking with Constraints**. We build the string character by character, ensuring at each step that the parentheses can still be closed properly.

### 🛠️ The Strategy:
1. **Base Case:** When the length of the string reaches `n * 2`, we have a complete and valid combination. Add it to the result list.
2. **Recursive Choices:**
   - **Add an Open Parenthesis:** We can add `(` if the number of `open` brackets is less than `n`.
   - **Add a Close Parenthesis:** We can add `)` only if the number of `close` brackets is less than the number of `open` brackets currently in the string.
3. **Pruning:** By following these two rules, we never generate an invalid sequence like `)(` or `())`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟰ⁿ / √𝗻) - This follows the $n^{th}$ Catalan number. It is the number of valid parenthesized expressions.
* **Space Complexity:** 𝙊(𝗻) - The maximum depth of the recursion stack is $2n$.

## 💻 Implementation (Java)
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
    
    private void helper(List<String> list, String s, int open, int close, int max){
        // Base case: string is complete
        if(s.length() == max * 2){
            list.add(s);
            return;
        }
        
        // Rule 1: We can always add '(' if we haven't reached the limit
        if(open < max){
            helper(list, s + "(", open + 1, close, max);
        }
        
        // Rule 2: We can only add ')' if it closes an existing '('
        if(close < open){
            helper(list, s + ")", open, close + 1, max);
        }
    }
}
