# 350. Intersection of Two Arrays II (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays.

## 💡 Intuition & Approach
To handle duplicate elements in the intersection, we need to track how many times each number appears in both arrays. A Frequency Map (HashMap) is ideal for this.

### 🛠️ The Strategy:
1. **Frequency Mapping:** Iterate through the smaller array (or `nums1`) and store the count of each element in a `HashMap`.
2. **Intersection Check:** Iterate through the second array (`nums2`).
   - If the current number exists in the map and its count is greater than 0:
     - Add the number to our result list.
     - Decrement the count in the map to "consume" that occurrence.
3. **Array Conversion:** Convert the dynamic list into the required primitive integer array.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗺) - We traverse both arrays once to build the map and find the intersection.
* **Space Complexity:** 𝙊(𝗺𝗶𝗻(𝗻, 𝗺)) - We store the frequencies of elements from one array in the HashMap.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Build frequency map for nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        // Check nums2 against the frequency map
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert list to int array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
