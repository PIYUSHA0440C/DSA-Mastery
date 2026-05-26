# 3120. Count the Number of Special Characters I (Easy)

## 📝 Problem Statement
You are given a string `word`. A letter is defined as **special** if it appears both in lowercase and uppercase within the string. Return the total number of unique special letters.

## 💡 Intuition & Approach
The position or sequence of the characters does not matter for this problem; we only care about their existence. A `HashSet` is an ideal tool here because it eliminates duplicates and provides $O(1)$ lookup times.

### 🛠️ The Strategy:
1. **Deduplicate:** Traverse the string `word` and insert every character into a `HashSet` named `set`.
2. **Alphabet Scan:** Loop through all 26 lowercase English letters from `'a'` to `'z'`.
3. **Paired Check:** For each lowercase letter `ch`:
   - Check if `set` contains `ch`.
   - Calculate its uppercase counterpart using ASCII arithmetic (`ch - 'a' + 'A'`) and check if the set contains it as well.
4. **Accumulate:** If both versions exist in the set, increment our `count`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - We iterate through the string once to populate the set ($O(N)$). The second loop always runs exactly 26 times ($O(1)$), leading to a linear overall runtime.
* **Space Complexity:** 𝙊(𝟭) - Although we use a `HashSet`, it will store at most 52 unique characters (26 lowercase + 26 uppercase English letters), which satisfies constant space requirements.

## 💻 Implementation (Java)
```java
class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        // Step 1: Store all present characters into a set
        for (char ch : word.toCharArray()) {
            set.add(ch);
        }

        // Step 2: Look for lowercase and uppercase pairs
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char upperCh = (char) (ch - 'a' + 'A');
            if (set.contains(ch) && set.contains(upperCh)) {
                count++;
            }
        }

        return count;
    }
}
