# 454. 4Sum II (Medium)

## 📝 Problem Statement
Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` of length `n`, return the number of tuples `(i, j, k, l)` such that their sum equals zero.

## 💡 Intuition & Approach
A brute force approach using four nested loops would result in $O(N^4)$, which is too slow for $n=200$. We can optimize this by splitting the problem in half.

### 🛠️ The Strategy:
1. **Divide and Conquer:** Split the four arrays into two groups: (`nums1`, `nums2`) and (`nums3`, `nums4`).
2. **First Half Mapping:** Iterate through all possible sums of `nums3[k] + nums4[l]` and store the frequencies of these sums in a `HashMap`.
3. **Second Half Lookup:** Iterate through all possible sums of `nums1[i] + nums2[j]`. 
   - For each sum, calculate the "target" needed to reach zero: `target = -(nums1[i] + nums2[j])`.
   - Check if this target exists in the map. If it does, add its frequency to our total count.
4. **Why this works:** If $(a + b) + (c + d) = 0$, then $(a + b) = -(c + d)$.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - We run two sets of nested loops, each taking $O(n^2)$ time.
* **Space Complexity:** 𝙊(𝗻²) - In the worst case, the HashMap stores $n^2$ distinct sums.

## 💻 Implementation (Java)
```java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Store all possible sums of nums3 and nums4
        for (int k : nums3) {
            for (int l : nums4) {
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
            }
        }
        
        int count = 0;
        // Find complements in sums of nums1 and nums2
        for (int i : nums1) {
            for (int j : nums2) {
                count += map.getOrDefault(-(i + j), 0);
            }
        }
        
        return count;
    }
}
