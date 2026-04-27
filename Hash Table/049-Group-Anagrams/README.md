# 49. Group Anagrams (Medium)

## 📝 Problem Statement
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

## 💡 Intuition & Approach
The core task is to find a unique identifier for all strings that are anagrams of each other. 

### 🛠️ The Strategy:
1. **Sort for Normalization:** Anagrams consist of the same characters with the same frequencies. Sorting the characters of "eat", "tea", and "ate" all result in "aet".
2. **HashMap Grouping:**
   - Use a `HashMap<String, List<String>>`.
   - The **Key** is the sorted version of the string.
   - The **Value** is a list containing the original strings that share that sorted key.
3. **Execution:** Iterate through each string, generate its sorted key, and append the original string to the corresponding list in the map.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 × 𝗞 𝗹𝗼𝗴 𝗞) - $N$ is the number of strings, and $K$ is the maximum length of a string. Each string is sorted once.
* **Space Complexity:** 𝙊(𝗡 × 𝗞) - Necessary to store the strings and the mapping in the HashMap.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: Sorted Signature -> List of Anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // If the signature is new, initialize the list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            // Map the original word to its sorted signature group
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
