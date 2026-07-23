# 3513. Number of Unique XOR Triplets I (Medium)

## 📝 Problem Statement

You are given an integer array `nums` of length `n`, where `nums` is a permutation of the integers from `1` to `n`.

A **XOR triplet** is defined as:

```
nums[i] XOR nums[j] XOR nums[k]
```

where `i ≤ j ≤ k`.

Return the number of **unique XOR values** that can be obtained from all possible triplets.

---

## 💡 Intuition & Approach

A straightforward solution would enumerate all possible triplets and compute their XOR values. However, this would require **O(n³)** time, which is infeasible for `n` up to `10⁵`.

The key observation is that the array is a **permutation of the integers `[1, n]`**, so the answer depends only on `n`, not on the arrangement of the elements.

- If `n ≤ 2`, the only possible XOR values are the elements themselves, so the answer is simply `n`.
- For `n ≥ 3`, every XOR value from `0` up to the largest value representable using the required number of bits can be generated.
- Therefore, the answer is the **smallest power of two that is strictly greater than `n`**.

This can be computed efficiently by repeatedly doubling a value starting from `1` until it exceeds `n`.

### 🛠️ The Strategy

1. **Handle Small Arrays**
   - If `n ≤ 2`, return `n`.

2. **Find the Next Power of Two**
   - Start with `ans = 1`.
   - Keep left-shifting (`ans <<= 1`) until `ans > n`.

3. **Return the Result**
   - The computed power of two equals the number of distinct XOR triplet values.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(log n)** - At most one iteration for each bit position.

- **Space Complexity:** **O(1)** - Only a single integer variable is used.

---

## 💻 Implementation (Java)

```java
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2)
            return n;

        int ans = 1;
        while (ans <= n)
            ans <<= 1;

        return ans;
    }
}
```
