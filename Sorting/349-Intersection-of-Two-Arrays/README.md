# 349. Intersection of Two Arrays (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be **unique**, and you may return the result in any order.



[Image of Venn diagram intersection of two sets]


## 💡 Intuition & Approach
To find common elements efficiently, we need a way to look up numbers from one array while traversing the other. A `HashSet` provides average $O(1)$ time complexity for lookups.

### 🛠️ The Strategy:
1. **Reference Set:** Add all elements of `nums1` into a `HashSet`. This filters out duplicates from the first array and allows fast searching.
2. **Comparison:** Iterate through `nums2`. If an element exists in the reference set, it's a common element.
3. **Unique Results:** To ensure the result array has unique elements (as per the problem), we add common elements into a *second* `HashSet`.
4. **Final Conversion:** Convert the result `HashSet` into the required `int[]` format.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 + 𝗻) - We iterate through both arrays exactly once.
* **Space Complexity:** 𝙊(𝗺 + 𝗻) - In the worst case, we store all elements in sets.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        // Load reference set
        for (int n : nums1) set.add(n);
        
        // Find intersection
        for (int n : nums2) {
            if (set.contains(n)) {
                res.add(n);
            }
        }

        // Convert to result array
        int[] ans = new int[res.size()];
        int i = 0;
        for (int n : res) ans[i++] = n;

        return ans;
    }
}
