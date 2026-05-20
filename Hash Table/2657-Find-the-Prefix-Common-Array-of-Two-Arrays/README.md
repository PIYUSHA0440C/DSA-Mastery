# 2657. Find the Prefix Common Array of Two Arrays (Medium)

## 📝 Problem Statement
You are given two $0$-indexed integer permutations `A` and `B` of length `n`. Return a prefix common array `C` where `C[i]` is equal to the count of numbers present at or before index `i` in both `A` and `B`.

## 💡 Intuition & Approach
The brute-force method involves checking all elements up to index `i` for matches, which takes $O(n^2)$ time. However, because both arrays are **permutations** of numbers from $1$ to $n$, we know that each number can appear at most once in `A` and once in `B`.

Therefore, if a number's total frequency across both prefixes reaches **2**, it means that the number has appeared in both `A` and `B` at or before the current index.

### 🛠️ The Strategy:
1. **Frequency Tracker:** Initialize a frequency array `freq` of size `n + 1` to keep track of how many times each number has been seen so far.
2. **Running Count:** Maintain a `common` counter to store the total number of common elements found up to the current index.
3. **Single Pass Scan:**
   - For every index `i`, increment the frequency of `A[i]`. If it reaches `2`, increment `common`.
   - Increment the frequency of `B[i]`. If it reaches `2`, increment `common`.
   - Record the current `common` value into our result array `ans[i]`.
4. **Return** the completed `ans` array.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We process the arrays in a single pass of length $n$. Each lookup and update inside the loop takes constant $O(1)$ time.
* **Space Complexity:** 𝙊(𝗻) - An auxiliary frequency array of size $n + 1$ is used to store values, which is highly efficient given the maximum constraint of $n = 50$.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1]; 
        int[] ans = new int[n];
        int common = 0;

        // Linear scan leveraging permutation properties
        for (int i = 0; i < n; i++) {
            // If frequency becomes 2, it means the number exists in both prefixes
            if (++freq[A[i]] == 2) common++;
            if (++freq[B[i]] == 2) common++;

            ans[i] = common;
        }

        return ans;
    }
}
