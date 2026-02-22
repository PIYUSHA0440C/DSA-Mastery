# 383. Ransom Note (Easy)

## 📝 Problem Statement
Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise. Each letter in `magazine` can only be used once.

## 💡 Intuition & Approach
This is a frequency-counting problem. We need to ensure that the `magazine` contains at least as many of each character as the `ransomNote` requires.

### 🛠️ The Strategy:
1. **Supply Count:** Build a frequency map of all characters in the `magazine`.
2. **Demand Check:** Iterate through the `ransomNote`. For each character:
   - If the character isn't in the map or its count is `0`, return `false`.
   - Otherwise, decrement the count in the map to "use" the letter.
3. **Success:** If we finish the loop, it means we had enough "supply" for the "demand."



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 + 𝗻) - Where $m$ is the length of `magazine` and $n$ is the length of `ransomNote`. We traverse each string once.
* **Space Complexity:** 𝙊(𝗸) - Where $k$ is the number of unique characters. Since the input only contains lowercase English letters, $k$ is at most 26, making this $O(1)$ in practice.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Build the inventory from magazine
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Check if ransomNote can be satisfied
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            }
            // Consume the character
            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}
