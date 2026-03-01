# 75. Sort Colors (Medium)

## 📝 Problem Statement
Given an array `nums` with $n$ objects colored red (0), white (1), or blue (2), sort them **in-place** so that objects of the same color are adjacent in the order 0, 1, then 2.

## 💡 Intuition & Approach
This is the **Dutch National Flag** problem. We maintain three sections in the array using three pointers:
1. `low`: Boundary for 0s (Red).
2. `mid`: Current element being inspected (White section).
3. `high`: Boundary for 2s (Blue).

### 🛠️ The Strategy:
- **If `nums[mid] == 0`**: Swap with `nums[low]`. Both `low` and `mid` move forward. We know the swapped value at `mid` is now a 1 or was already processed.
- **If `nums[mid] == 1`**: It's in the right place for now. Just move `mid` forward.
- **If `nums[mid] == 2`**: Swap with `nums[high]`. Move `high` backward. We **don't** increment `mid` yet because the new value swapped from `high` needs to be inspected.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Every element is visited at most once in a single pass.
* **Space Complexity:** 𝙊(𝟭) - Sorting is done in-place without any extra arrays.

## 💻 Implementation (Java)
```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                // Swap mid with low
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1){
                // White is already in the middle, just skip
                mid++;
            } else {
                // Swap mid with high
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
                // Don't increment mid; check the swapped element
            }
        }
    }
}
