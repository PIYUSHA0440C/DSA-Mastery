# 84. Largest Rectangle in Histogram (Hard)

## 📝 Problem Statement
Given an array of integers `heights` representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

## 💡 Intuition & Approach
A brute-force strategy looks at every possible pair of bars and finds the minimum height between them, which runs in slow $O(N^2)$ time. To solve this in optimal linear $O(N)$ time, we can focus on each bar individually and ask: **"What is the maximum width this bar can extend to the left and right to form a rectangle where it is the shortest bar?"**

A bar can expand horizontally as long as it encounters neighboring bars that are greater than or equal to its own height. The moment it hits a shorter bar, its expansion is blocked. Therefore, the boundary of expansion for any bar `i` is determined by:
1. The **Nearest Smaller Element to the Left** (index stored in `left[i]`)
2. The **Nearest Smaller Element to the Right** (index stored in `right[i]`)

We use a **Monotonic Increasing Stack** to precompute these boundaries efficiently for all positions in a single pass.

### 🛠️ The Strategy:
1. **Nearest Smaller to Left (NSL):** Traverse the array from left to right. Maintain indices in a stack such that the corresponding heights are strictly increasing. Pop elements if they are greater than or equal to the current height. If the stack is empty, there is no left boundary (`left[i] = -1`); otherwise, `left[i] = stack.peek()`.
2. **Nearest Smaller to Right (NSR):** Clear the stack and traverse from right to left. Follow the same popping logic. If the stack is empty, there is no right boundary (`right[i] = n`); otherwise, `right[i] = stack.peek()`.
3. **Area Computation:** Iterate through all elements. Calculate the maximum reachable width for each bar using the formula: `width = right[i] - left[i] - 1`. The area achieved by using the current bar as the bottleneck height is `heights[i] * width`. Capture the maximum of these calculated areas.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) — Every bar index is pushed onto and popped off the stack at most once during each of the linear boundary scans.
* **Space Complexity:** O(N) — Auxiliary arrays (`left` and `right`) and the stack structure store up to $N$ indices in memory.

## 💻 Implementation (Java)
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Phase 1: Compute Nearest Smaller Element to Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); // Clear stack for reuse

        // Phase 2: Compute Nearest Smaller Element to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Phase 3: Calculate the maximum area container possible
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}
