# 350. Intersection of Two Arrays II (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays.

## 💡 Intuition & Approach
To handle the "count" of each number, a frequency map is the most efficient tool. We need to find the minimum frequency of each common element across both arrays.

### 🛠️ The Strategy:
1. **Frequency Mapping:** Map all elements of the smaller array (to save space) to their counts in a `HashMap`.
2. **Intersection Check:** Iterate through the second array. If an element exists in the map with a count > 0:
   - Add it to the result list.
   - Decrement its count in the map to "use" it.
3. **Array Conversion:** Convert the resulting list back into a primitive integer array.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗺) - We traverse `nums1` to build the map and `nums2` to find the intersection.
* **Space Complexity:** 𝙊(𝗺𝗶𝗻(𝗻, 𝗺)) - The HashMap stores elements from the first array.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Optimization: Use the smaller array for the map to save space
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
