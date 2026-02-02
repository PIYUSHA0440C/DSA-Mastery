# 349. Intersection of Two Arrays (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be **unique**, and you may return the result in any order.



## 💡 Intuition & Approach
The goal is to find common elements. Using a Hash-based data structure allows us to perform lookups in constant time, making the process highly efficient.

### 🛠️ The Strategy:
1. **First Set:** Store all unique elements of `nums1` into a `HashSet`. This acts as our "reference" pool.
2. **Intersection Check:** Iterate through `nums2`. For each element, check if it exists in the first set.
3. **Unique Results:** If a match is found, add it to a *second* `HashSet` (the results set). Using a second set automatically handles duplicates in `nums2`.
4. **Conversion:** Convert the results set back into a primitive `int[]` for the final answer.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 + 𝗻) - We traverse both arrays once.
* **Space Complexity:** 𝙊(𝗺 + 𝗻) - In the worst case, we store all elements in HashSets.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        // Add all elements of nums1 to a set for O(1) lookups
        for (int n : nums1) set.add(n);
        
        // Find common elements
        for (int n : nums2) {
            if (set.contains(n)) {
                res.add(n);
            }
        }

        // Convert HashSet to int array
        int[] ans = new int[res.size()];
        int i = 0;
        for (int n : res) ans[i++] = n;

        return ans;
    }
}
