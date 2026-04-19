# 1855. Maximum Distance Between a Pair of Values (Medium)

## 📝 Problem Statement
Given two non-increasing arrays `nums1` and `nums2`, find the maximum distance $(j - i)$ such that $i \le j$ and $nums1[i] \le nums2[j]$.

## 💡 Intuition & Approach
Because the arrays are sorted in descending order (non-increasing), we can use a **Two-Pointer** strategy to find the optimal pair in $O(n + m)$ time.

### 🛠️ The Strategy:
1. **Pointers:** Initialize `i = 0` (for `nums1`) and `j = 0` (for `nums2`).
2. **Expansion:** If `nums1[i] <= nums2[j]`:
   - This is a valid pair! 
   - Update `result = max(result, j - i)`.
   - Try to increase the distance by moving `j` forward.
3. **Contraction:** If `nums1[i] > nums2[j]`:
   - The current `nums1[i]` is too large for the current `nums2[j]`.
   - Since `nums2` is non-increasing, moving `j` further will only make `nums2[j]` smaller. 
   - Therefore, we must increment `i` to find a smaller value in `nums1`.
4. **Constraint:** The condition $i \le j$ is naturally handled by the logic; if `i` ever exceeds `j` during an `i++` step, the `nums1[i] <= nums2[j]` check will eventually catch up or `j` will move forward.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗺) - Each pointer moves from start to end at most once.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        int i = 0;
        int j = 0;

        // Traverse both arrays using two pointers
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                // Valid pair, record distance and try to expand j
                result = Math.max(result, j - i);
                j++;
            } else {
                // nums1[i] too large, move to a smaller value in nums1
                i++;
            }
        }

        return result;
    }
}
