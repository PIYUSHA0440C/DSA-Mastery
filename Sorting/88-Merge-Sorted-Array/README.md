# 88. Merge Sorted Array (Easy)

## 📝 Problem Statement
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`. 

Merge `nums1` and `nums2` into a single array sorted in non-decreasing order. The result must be stored **inside** `nums1` (in-place). `nums1` has a total length of `m + n`.



## 💡 Intuition & Approach
If we merge from the beginning, we have to overwrite elements in `nums1`, which would require an auxiliary array or expensive shifting. However, the end of `nums1` is filled with dummy zeros. 

### 🛠️ The Strategy:
1. **Three Pointers:** - `index1`: Points to the last valid element in `nums1` ($m-1$).
   - `index2`: Points to the last element in `nums2` ($n-1$).
   - `i`: Points to the very last index of the combined `nums1` array ($m+n-1$).
2. **Backward Comparison:** Compare `nums1[index1]` and `nums2[index2]`. Place the larger value at `nums1[i]` and move the corresponding pointers backward.
3. **The "Leftover" Rule:** If `index2` is still $\ge 0$ after `index1` is exhausted, we simply copy the remaining elements of `nums2` into `nums1`. If `index1` is left over, they are already in their correct sorted positions.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 + 𝗻) - We traverse each element in both arrays exactly once.
* **Space Complexity:** 𝙊(𝟭) - The merge happens in-place within `nums1`.

## 💻 Implementation (Java)
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        
        int index1 = m - 1; // Last element in nums1 part
        int index2 = n - 1; // Last element in nums2
        int i = nums1.length - 1; // Last position in total array
        
        // We only need to care about index2 because nums1 is already in place
        while(index2 >= 0){
            if(index1 >= 0 && nums1[index1] > nums2[index2]){
                nums1[i] = nums1[index1];
                index1--;
            } else {
                nums1[i] = nums2[index2];
                index2--;
            }
            i--;
        }
    }
}
