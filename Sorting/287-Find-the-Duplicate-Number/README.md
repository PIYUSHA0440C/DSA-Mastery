# 287. Find the Duplicate Number (Medium)

## 📝 Problem Statement
Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive. There is only **one repeated number**, return this repeated number.

**Note:** The problem constraints specify not modifying the array. This solution uses **Cyclic Sort** (which modifies the input) to master the index-mapping pattern. I will implement the non-modifying **Floyd's Cycle Finding** approach in a future session.



## 💡 Intuition & Approach
Using the **Pigeonhole Principle**, we know that if we have $n$ slots and $n+1$ numbers, at least one slot must have a duplicate. By trying to place each number in its "natural home" (value `x` at `index x-1`), the duplicate will eventually try to move into a slot that is already occupied by its twin.

### 🛠️ The Strategy:
1. **Iterate:** Loop through the array using index `i`.
2. **Check Position:** If `nums[i]` is not at `index i+1`, identify its `correct` target index.
3. **Collision Detection:** - If `nums[i]` is different from `nums[correct]`, swap them.
   - If `nums[i]` is the **same** as `nums[correct]`, we found the duplicate! Return it immediately.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Linear scan with in-place swaps.
* **Space Complexity:** 𝙊(𝟭) - Constant extra space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums, i, correct);
                } else {
                    // Correct position already has this value -> Duplicate found
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    void swap(int[] nums, int current, int correct){
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
