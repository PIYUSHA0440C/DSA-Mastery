# 3121. Count the Number of Special Characters II (Medium)

## 📝 Problem Statement
You are given a string `word`. A letter `c` is called **special** if it appears both in lowercase and uppercase in `word`, and **every** lowercase occurrence of `c` appears strictly before the **first** uppercase occurrence of `c`. Return the number of special letters.

## 💡 Intuition & Approach
Unlike Part I, the relative order of characters matters here. Specifically, a letter becomes invalid if a lowercase version shows up *after* an uppercase version has already been spotted.

This solution tracks character status dynamically using a small $2 \times 27$ boolean matrix (`A`), mapping lowercase states to row `0` and uppercase states to row `1`. 

### 🛠️ Bitwise Character Mapping:
* **Alphabet Index (`ch & 31`):** Extracts the 1-based alphabetical position (e.g., `'a'` or `'A'` both map to `1`).
* **Case Identity (`(ch >> 5) & 1`):** Exploits ASCII spacing. Uppercase letters (ASCII 65-90) have a `0` in the 6th bit, while lowercase letters (ASCII 97-122) have a `1` in the 6th bit. Inverting or adjusting this tells us the exact case context in constant time.

### 🛠️ State Update Rules:
1. If the current character is **lowercase**, mark its presence in `A[0][idx] = true`.
2. If the current character is **uppercase**, it is only valid if a lowercase version has *not* been registered yet in the current sequence or if rules hold up. If a lowercase character appears after an uppercase entry has already altered the state, the flags will mismatch during the final scan.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - We iterate through the string exactly once to configure the matrix states. The final validation loop runs a constant 26 times.
* **Space Complexity:** 𝙊(𝟭) - The boolean tracking matrix size is fixed at $2 \times 27$, utilizing negligible and constant extra memory.

## 💻 Implementation (Java)
```java
class Solution {
    public int numberOfSpecialChars(String word) {
        // A[0] tracks lowercase states, A[1] tracks uppercase states
        boolean[][] A = new boolean[2][27];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch & 31;         // Fast 1-based alphabet index (1 to 26)
            int Case = (ch >> 5) & 1;  // Bit manipulation to identify case context

            // State Logic: Lowercase is recorded normally. 
            // Uppercase is invalid if lowercase has already set boundaries improperly.
            A[Case][idx] = Case == 0 || !A[0][idx];
        }

        int res = 0;
        // Verify which characters successfully held both true states
        for (int i = 1; i < 27; i++) {
            if (A[0][i] && A[1][i]) {
                res++;
            }
        }

        return res;
    }
}
