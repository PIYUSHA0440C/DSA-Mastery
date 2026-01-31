# 448. Find All Numbers Disappeared in an Array (Easy)

## 📝 Problem Statement
Given an array `nums` of `n` integers where each integer is in the range `[1, n]`, return an array of all the integers that do not appear in `nums`.

**Goal:** Solve it in **O(n)** time and **O(1)** extra space (excluding the result list).



## 💡 Intuition & Approach
Since the numbers are in the range `[1, n]`, they "belong" to indices `[0, n-1]`. By using **Cyclic Sort**, we can place every number at its correct index.

### 🛠️ The Strategy:
1. **In-place Sorting:** Iterate through the array. If `nums[i]` is not at its correct position (`i + 1`) and the number at its target position is different, swap them.
2. **Ignore Duplicates during Sort:** If we encounter a number that is already present at its correct index (a duplicate), we simply move on.
3. **Identify Mismatches:** After the loop, any index `i` where `nums[i] != i + 1` means that the number `i + 1` is missing from the array.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each element is visited and potentially swapped into its correct place once.
* **Space Complexity:** 𝙊(𝟭) - We modify the input array and do not use extra space besides the output list.

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int i = 0;
        
        // Phase 1: Cyclic Sort
        while(i < len) {
            int correct = nums[i] - 1; // Correct index for nums[i] is nums[i] - 1
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        // Phase 2: Finding missing numbers
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int current, int correct) {
        int temp = nums[correct];
        nums[correct] = nums[current];
        nums[current] = temp;
    }
}
