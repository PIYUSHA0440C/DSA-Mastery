# 229. Majority Element II (Medium)

## 📝 Problem Statement
Given an integer array of size `n`, find all elements that appear more than $\lfloor n/3 \rfloor$ times.

## 💡 Intuition & Approach
The goal is to identify elements with a high frequency. A frequency map (HashMap) allows us to count occurrences in a single pass and then filter based on the threshold.

### 🛠️ The Strategy:
1. **Frequency Mapping:** Use a `HashMap<Integer, Integer>` to store each number and its count.
2. **Threshold Calculation:** The required frequency is strictly greater than `n / 3`.
3. **Filtering:** Iterate through the keys of the map. If a key's value exceeds the threshold, add it to the result list.
4. **Mathematical Bound:** Note that there can be at most 2 such elements in any given array (since $3 \times (n/3 + 1) > n$).

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - One pass to build the map and one pass over the unique keys.
* **Space Complexity:** 𝙊(𝗻) - In the worst case (all elements unique), the map stores $n$ entries.

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each number
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        
        // Identify elements exceeding n/3
        for(int key : map.keySet()) {
            if(map.get(key) > threshold) {
                result.add(key);
            }
        }

        return result;
    }
}
