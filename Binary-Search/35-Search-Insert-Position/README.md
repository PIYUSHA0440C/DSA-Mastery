# 35. Search Insert Position (Easy)

## 📝 Problem Statement
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

**Requirement:** You must write an algorithm with **O(log n)** runtime complexity.



## 💡 Intuition & Approach
This is a classic application of **Binary Search**. The goal is to find the target index or the position where the target *should* have been.

1. **Standard Binary Search:** We use two pointers, `start` and `end`.
2. **Found Case:** If `nums[mid] == target`, we return `mid` immediately.
3. **Not Found Case:** If the target is not in the array, the `while` loop will eventually break when `start > end`.
4. **The "Insert" Secret:** At the moment the loop breaks, the `start` pointer will always be sitting at the index where the target should be inserted to maintain the sorted order.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - The search space is halved at each step.
* **Space Complexity:** 𝙊(𝟭) - No extra space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid; // Target found
            } else if(nums[mid] > target){
                end = mid - 1; // Look left
            } else {
                start = mid + 1; // Look right
            }
        }
        
        // If not found, start is the index where target would be inserted
        return start;
    }
}
