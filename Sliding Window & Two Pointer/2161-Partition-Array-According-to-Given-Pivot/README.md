# 2161. Partition Array According to Given Pivot (Medium)

## 📝 Problem Statement
You are given a 0-indexed integer array `nums` and an integer `pivot`. Rearrange `nums` such that:
1. Every element less than `pivot` appears before every element greater than `pivot`.
2. Every element equal to `pivot` appears in between the elements less than and greater than `pivot`.
3. The **relative order** of the elements less than pivot and the elements greater than pivot is strictly maintained.

Return `nums` after the rearrangement.

## 💡 Intuition & Approach
The fundamental challenge of this problem is maintaining the **stable relative order** of elements while avoiding multiple sequential iterations or heavy object allocations (like tracking items in separate `ArrayList` structures).

We can optimize this to a single-pass extraction using a bidirectional dual-pointer technique:
* **Forward Pointer (`i`):** Moves from left to right (`0` to `len - 1`). Whenever it encounters an element *less than* the pivot, it safely appends it to the front of our output array using a tracking pointer `left`.
* **Backward Pointer (`j`):** Moves from right to left (`len - 1` down to `0`). Whenever it encounters an element *greater than* the pivot, it appends it to the back of our output array using a tracking pointer `right`.

Because both pointers scan elements in their natural chronological sequence, the stable relative ordering constraint is perfectly preserved for both groups. Once the loop concludes, any unallocated slots remaining between `left` and `right` are safely filled with the `pivot` value.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We process the entire array in a single concurrent pass containing constant-time condition checks. A short subsequent linear loop fills in the remaining middle values.
* **Space Complexity:** O(N) - An auxiliary array `ans` of size $N$ is required to hold and construct the rearranged sequence. No extra dynamic collection wrappers are generated.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] ans = new int[len];
        
        int i = 0, j = len - 1;
        int left = 0, right = len - 1;

        // Bidirectional single-pass scanning
        while (i < len && j >= 0) {
            // Forward pointer gathers smaller values to preserve stable order
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }
            // Backward pointer gathers larger values to preserve stable order
            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }

            i++;
            j--;
        }

        // Fill the remaining gap in the center with pivot values
        for (int k = left; k <= right; k++) {
            ans[k] = pivot;
        }

        return ans;
    }
}
