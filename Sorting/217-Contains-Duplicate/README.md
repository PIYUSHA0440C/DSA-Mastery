# 217. Contains Duplicate (Easy)

## 📝 Problem Statement
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.



## 💡 Intuition & Approach
To detect duplicates efficiently, we need a way to "remember" the elements we have already seen as we traverse the array.

### 🛠️ The Strategy:
1. **Hash-Based Tracking:** We use a `HashSet` to store the numbers.
2. **Early Exit:** For every number in the array:
   - Check if it already exists in the `HashSet` using `.contains()`.
   - If it does, we've found a duplicate—return `true` immediately.
   - If not, add the number to the set and continue.
3. **Completion:** If the loop finishes without finding any matches, return `false`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the array once, and HashSet operations (add/contains) take $O(1)$ on average.
* **Space Complexity:** 𝙊(𝗻) - In the worst case (no duplicates), we store all $n$ elements in the set.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashSet to store unique elements encountered so far
        HashSet<Integer> seen = new HashSet<>();
        
        for (int i : nums) {
            // If the element is already in the set, we found a duplicate
            if (seen.contains(i)) {
                return true;
            }
            // Otherwise, add the current element to the set
            seen.add(i);
        }
        
        // No duplicates found after traversing the whole array
        return false;
    }
}
