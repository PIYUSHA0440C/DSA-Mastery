# 219. Contains Duplicate II (Easy)

## 📝 Problem Statement
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that `nums[i] == nums[j]` and `abs(i - j) <= k`.

## 💡 Intuition & Approach
To solve this efficiently, we need to track both the value and the most recent index where that value appeared. A **HashMap** is the ideal data structure for this.

### 🛠️ The Strategy:
1. **The Map:** Create a `HashMap<Integer, Integer>` where the *Key* is the number and the *Value* is its index.
2. **One-Pass Check:** Iterate through the array. 
   - If the current number is already in the map, calculate the distance between the current index `i` and the stored index.
   - If `i - stored_index <= k`, we've found a "nearby" duplicate. Return `true`.
3. **Update Index:** Always update the map with the current index: `map.put(nums[i], i)`. This ensures that for future checks, we are comparing against the *closest* previous occurrence.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array exactly once. HashMap lookups and inserts are $O(1)$ on average.
* **Space Complexity:** 𝙊(𝗻) - In the worst case, we store every element of the array in the map.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store value -> last seen index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Check if element exists and if distance is within k
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            // Update the map with the latest index
            map.put(nums[i], i);
        }
        
        return false;
    }
}
