# 1207. Unique Number of Occurrences (Easy)

## 📝 Problem Statement
Given an array of integers `arr`, return `true` if the number of occurrences of each value in the array is unique, or `false` otherwise.

## 💡 Intuition & Approach
The goal is to verify that no two distinct numbers appear the same number of times.

### 🛠️ The Strategy:
1. **Count Frequencies:** Use a `HashMap<Integer, Integer>` to store each number and its corresponding count (frequency).
2. **Collect Frequencies:** Extract all the values (counts) from the map.
3. **Verify Uniqueness:** Add these counts into a `HashSet`. 
   - Since a `HashSet` automatically removes duplicates, if any two numbers had the same frequency, the size of the set will be smaller than the number of unique elements in the original array.
4. **Final Check:** Return `true` if `map.size() == set.size()`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once to build the map, and then iterate over the map entries once.
* **Space Complexity:** 𝙊(𝗻) - In the worst case where all elements are unique, we store $N$ elements in the map and $N$ counts in the set.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        // Step 1: Count occurrences of each number
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a HashSet to check if frequency values are unique
        Set<Integer> uniqueCounts = new HashSet<>(occurrences.values());

        // If sizes match, all frequencies were unique
        return occurrences.size() == uniqueCounts.size();
    }
}
