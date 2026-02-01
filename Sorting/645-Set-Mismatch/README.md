# 645. Set Mismatch (Easy)

## 📝 Problem Statement
You have a set of integers `s` which originally contained all numbers from `1` to `n`. Due to an error, one number was duplicated, causing another number to go missing. Given the array `nums`, find and return the duplicate number and the missing number.



## 💡 Intuition & Approach
This is the ultimate **Cyclic Sort** problem. Since we are dealing with a range from `1` to `n`, every number has a unique index where it belongs (`index = value - 1`).

### 🛠️ The Strategy:
1. **Cyclic Sort Phase:** We iterate through the array and swap each number to its correct index. If we find a number already at its correct index, we skip it.
2. **Analysis Phase:** We scan the "sorted" array.
   - The value currently at `nums[i]` is the **Duplicate** (because it's out of place).
   - The value that *should* have been at that index (`i + 1`) is the **Missing** number.
3. **Return:** Return these two values as an array: `[duplicate, missing]`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once for sorting and once for finding the error.
* **Space Complexity:** 𝙊(𝟭) - No auxiliary space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int i = 0;
        
        // Step 1: Cyclic Sort
        while(i < len){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Step 2: Find the mismatch
        for(i = 0; i < len; i++){
            if(nums[i] != i + 1){
                // nums[i] is the duplicate, i + 1 is what's missing
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1};
    }

    void swap(int[] nums, int current, int correct){
        int temp = nums[current];
        nums[current] = nums[correct];
        nums[correct] = temp;
    }
}
