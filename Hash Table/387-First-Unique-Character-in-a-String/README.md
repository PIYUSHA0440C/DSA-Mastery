# 387. First Unique Character in a String (Easy)

## 📝 Problem Statement
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return -1.

## 💡 Intuition & Approach
To find the first unique character, we need to know the total count of each character in the string. A two-pass approach is the most efficient way to handle this.

### 🛠️ The Strategy:
1. **Frequency Mapping:** Iterate through the string once and store the count of each character in a `HashMap`.
2. **First Occurrence Check:** Iterate through the string a second time. 
   - For each character at index `i`, check its count in the map.
   - The first character with a count of `1` is our answer.
3. **Fallback:** If the loop completes without finding a count of `1`, return `-1`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string twice ($2n$ operations).
* **Space Complexity:** 𝙊(𝟭) - Although we use a Map, it only stores lowercase English letters. The map size is capped at 26, which is constant space.

## 💻 Implementation (Java)
```java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Pass 1: Build the frequency map
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Pass 2: Find the first index with a frequency of 1
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
