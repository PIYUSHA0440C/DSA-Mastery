# 2540. Minimum Common Value (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer, return `-1`.

## 💡 Intuition & Approach
Since both arrays are already sorted in non-decreasing order, the very first common element we encounter from the beginning of the arrays is guaranteed to be the minimum common value. This layout perfectly suits a **Two-Pointer** approach.

### 🛠️ The Strategy:
1. **Early Exit Optimization:** Check if the largest element of one array is smaller than the smallest element of the other. If so, return `-1` immediately.
2. **Initialize Pointers:** Place pointer `i` at the start of `nums1` and pointer `j` at the start of `nums2`.
3. **Linear Comparison:**
   - If `nums1[i] == nums2[j]`, we have found our smallest match. Return it immediately.
   - If `nums1[i] > nums2[j]`, the element in `nums2` is too small to match anything ahead in `nums1`. Advance `j++`.
   - If `nums1[i] < nums2[j]`, the element in `nums1` is too small. Advance `i++`.
4. **Fallback:** If either pointer runs out of bounds without finding a match, return `-1`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗺) - In the worst case, we traverse both arrays linearly. If an intersection is found early or the early exit triggers, it runs much faster.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are allocated; pointers are modified in-place.

## 💻 Implementation (Java)
```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Early exit: Optimization check if intervals do not overlap at all
        if (nums1[len1 - 1] < nums2[0] || nums2[len2 - 1] < nums1[0]) return -1;
        
        // Two-pointer linear scan
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // First match is guaranteed to be the minimum
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return -1;
    }
}
