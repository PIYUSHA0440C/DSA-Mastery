# 496. Next Greater Element I (Easy)

## 📝 Problem Statement
The next greater element of some element `x` in an array is the first greater element that is to the right of `x` in the same array. You are given two distinct 0-indexed integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the next greater element of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this query is `-1`. Return an array `ans` of length `nums1.length` such that `ans[i]` is the next greater element as described above.

## 💡 Intuition & Approach
A naive approach would check every element to the right in `nums2` for each query, resulting in a slow $O(N \times M)$ runtime. To optimize this to linear time $O(N + M)$, we use a **Monotonic Decreasing Stack** combined with a **Hash Map**.

By traversing `nums2` from right to left, we maintain elements in the stack in a strictly increasing order from top to bottom. For each element, any smaller elements currently on top of the stack are useless for numbers further to the left, so we pop them. The element at the top of the stack after this pruning becomes the immediate "next greater element". We then store this relationship in a hash map for $O(1)$ lookups when answering queries from `nums1`.

### 🛠️ The Strategy:
1. **Right-to-Left Traversal:** Initialize an array `nge` and a `Stack`. Start processing `nums2` from the last index down to `0`.
2. **Monotonic Pruning:** While the stack is not empty and the top element is less than or equal to the current element `nums2[i]`, remove it via `st.pop()`.
3. **Record Next Greater:** If the stack becomes empty, no greater element exists to the right; set `nge[i] = -1`. Otherwise, the element at `st.peek()` is the next greater element. Push the current element onto the stack.
4. **Map Mapping:** Build a hash map pairing each number in `nums2` to its calculated next greater element.
5. **Answer Queries:** Loop through `nums1`, pulling the precomputed answers out of the map in constant time.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Where $N$ is the length of `nums2` and $M$ is the length of `nums1`. Each element in `nums2` is pushed and popped from the stack at most once during the single linear pass. Map insertions and lookups operate in $O(1)$ time.
* **Space Complexity:** O(N) - Extra allocation used to store the monotonic stack entries and the lookup hash map pairs for elements of `nums2`.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] nge = new int[n];
        int[] ans = new int[m];
        Stack<Integer> st = new Stack<>();

        // Base case for the rightmost element
        nge[n - 1] = -1;
        st.push(nums2[n - 1]);

        // Process nums2 from right to left using a monotonic stack
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop(); // Pop smaller elements as they can't be a next greater element
            }
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(nums2[i]); // Push current element onto the stack
        }

        // Map elements of nums2 to their next greater element
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], nge[i]);
        }

        // Map answers directly back to nums1 queries
        for (int i = 0; i < m; i++) {
            if (map.containsKey(nums1[i])) {
                ans[i] = map.get(nums1[i]);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
