# 503. Next Greater Element II (Medium)

## 📝 Problem Statement

Given a **circular integer array** `nums`, return the **next greater element** for every element in the array.

The next greater element of a number is the first greater value encountered while traversing the array in its circular order. If no such element exists, return `-1` for that position.

---

## 💡 Intuition & Approach

A brute-force approach would search forward from every element, wrapping around the array if necessary, resulting in **O(n²)** time complexity.

To optimize this, we use a **Monotonic Decreasing Stack**.

The key challenge is the **circular nature** of the array. Instead of physically duplicating the array, we simulate two traversals by iterating from `2n - 1` down to `0` and accessing elements using `i % n`.

The stack always stores potential **next greater elements** in decreasing order.

For each element:

- Remove all elements from the stack that are smaller than or equal to the current element, since they can never be the next greater element.
- The remaining top of the stack (if any) is the next greater element.
- Push the current element onto the stack for future comparisons.

Traversing backwards ensures the stack already contains all possible candidates to the right, including those reachable through the circular wrap-around.

### 🛠️ The Strategy

1. **Initialize**
   - Create an answer array.
   - Maintain a monotonic decreasing stack.

2. **Simulate Circular Traversal**
   - Iterate from `2n - 1` down to `0`.
   - Access elements using `nums[i % n]`.

3. **Maintain the Stack**
   - Remove all elements smaller than or equal to the current value.
   - If processing the original array (`i < n`), record the stack's top as the next greater element, or `-1` if the stack is empty.

4. **Push Current Element**
   - Insert the current value into the stack before moving to the next iteration.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every element is pushed and popped from the stack at most once.

- **Space Complexity:** **O(n)** - The stack stores at most `n` elements.

---

## 💻 Implementation (Java)

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(current);
        }

        return nge;
    }
}
```
