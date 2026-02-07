# 1. Two Sum (Easy)

## 📝 Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

## 💡 Intuition & Approach
The goal is to find two numbers $x$ and $y$ such that $x + y = \text{target}$. This can be rewritten as $y = \text{target} - x$. 

As we iterate through the array, we treat the current number as $x$ and check if its "complement" ($y$) has already been seen. Using a `HashMap` allows us to store and look up these seen values in $O(1)$ time.

### 🛠️ The Strategy:
1. **One-Pass Hash Map:** Create a `HashMap<Integer, Integer>` to store `value -> index`.
2. **Complement Calculation:** For every number at index `i`, calculate `complement = target - nums[i]`.
3. **Lookup:** - If the complement exists in the map, we found the pair! Return `[map.get(complement), i]`.
   - If not, add the current number and its index to the map and keep moving.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the list containing $n$ elements only once. Each lookup in the table costs only $O(1)$ time.
* **Space Complexity:** 𝙊(𝗻) - The extra space required depends on the number of items stored in the hash table, which stores at most $n$ elements.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int complement = target - nums[i];
            
            // Check if we've already seen the number needed to reach target
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number and its index
            map.put(nums[i], i);
        } 

        return new int[]{}; // Only one valid answer exists per constraints
    }
}
