# 442. Find All Duplicates in an Array (Medium)

## 📝 Problem Statement
Given an integer array `nums` of length `n` where all integers are in the range `[1, n]` and each integer appears **at most twice**, return an array of all the integers that appear twice.

**Requirement:** - Time Complexity: **O(n)**
- Auxiliary Space: **O(1)** (excluding output list)

## 💡 Intuition & Approach
Since the values are constrained to `[1, n]`, we can use **Cyclic Sort** to place each number at its "home" index (`value - 1`). 

### 🛠️ The Strategy:
1. **In-place Sort:** Iterate through the array. Swap `nums[i]` with the element at its correct index (`nums[i] - 1`) as long as they are different.
2. **Handle Duplicates:** If a number's "home" is already occupied by the correct number, we move on. The duplicate will eventually be left at an index where it doesn't belong.
3. **Identify Duplicates:** Scan the array one more time. If `nums[i] != i + 1`, then `nums[i]` is a duplicate because it's sitting in a spot that should belong to a missing number.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We perform a constant number of swaps for each element.
* **Space Complexity:** 𝙊(𝟭) - No extra space used besides the required output list.

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        
        // Step 1: Cyclic Sort
        while(i < len) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Step 2: Identify numbers not at their correct index
        List<Integer> duplicates = new ArrayList<>();
        for(i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }
        return duplicates;
    }

    void swap(int[] nums, int current, int correct) {
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
