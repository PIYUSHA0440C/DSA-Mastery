# 448. Find All Numbers Disappeared in an Array (Easy)

## 📝 Problem Statement
Given an array `nums` of `n` integers where each integer is in the range `[1, n]`, return an array of all the integers that do not appear in `nums`.

**Goal:** Solve it in **O(n)** time and **O(1)** extra space (excluding the result list).

## 💡 Intuition & Approach
Since the numbers are in the range `[1, n]`, they have a "natural home" at indices `[0, n-1]`. By using **Cyclic Sort**, we can organize the array in-place.

### 🛠️ The Strategy:
1. **In-place Sorting:** Iterate through the array. If `nums[i]` is not at its correct position (`i + 1`) and the number at its target position is different, swap them.
2. **Handle Duplicates:** If we encounter a number that is already present at its correct index (a duplicate), we leave it where it is and move to the next index.
3. **Scan for Gaps:** After sorting, any index `i` where `nums[i] != i + 1` identifies that `i + 1` is a disappeared number.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each element is visited and potentially swapped only once.
* **Space Complexity:** 𝙊(𝟭) - We modify the input array in-place (the output list does not count as extra space).

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int i = 0;
        
        while(i < len) {
            int correct = nums[i] - 1; 
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
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
