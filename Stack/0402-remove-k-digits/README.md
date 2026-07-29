# 402. Remove K Digits (Medium)

## 📝 Problem Statement

Given a non-negative integer represented as a string `num` and an integer `k`, remove exactly `k` digits so that the resulting number is the **smallest possible**.

The returned number should not contain leading zeros. If all digits are removed, return `"0"`.

---

## 💡 Intuition & Approach

To obtain the smallest possible number, we should remove digits that are **larger than the digit immediately following them**.

A **Monotonic Increasing Stack** helps make this decision efficiently.

As we traverse each digit:

- If the current digit is smaller than the digit at the top of the stack, removing the larger digit results in a smaller number.
- Continue removing larger digits while removals are still available (`k > 0`).
- Push the current digit onto the stack.

After processing all digits:

- If removals are still left, remove digits from the end since they contribute the most to the final value.
- Construct the resulting number.
- Remove any leading zeros.
- If no digits remain, return `"0"`.

### 🛠️ The Strategy

1. **Traverse the Number**
   - Process each digit from left to right.

2. **Maintain a Monotonic Increasing Stack**
   - While the top digit is greater than the current digit and removals remain, pop the stack.
   - Push the current digit.

3. **Remove Remaining Digits**
   - If `k` is still greater than zero, remove digits from the top of the stack.

4. **Build the Result**
   - Convert the stack into a string.
   - Remove leading zeros.
   - Return `"0"` if the resulting string is empty.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every digit is pushed and popped at most once.

- **Space Complexity:** **O(n)** - The stack stores at most `n` digits.

---

## 💻 Implementation (Java)

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            char digit = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        while(k > 0) {
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        while(res.length() > 0 &&
              res.charAt(res.length() - 1) == '0'){
            res.deleteCharAt(res.length() - 1);
        }

        if(res.length() == 0) return "0";

        res.reverse();

        return res.toString();
    }
}
```
