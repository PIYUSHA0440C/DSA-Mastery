# 2423. Remove Letter To Equalize Frequency (Easy)

## 📝 Problem Statement
Given a string `word`, return `true` if you can remove **exactly one** character from the string such that the frequency of all remaining characters becomes equal. Otherwise, return `false`.

## 💡 Intuition & Approach
While it is possible to solve this using complex mathematical checks on frequency counts, there are many tricky edge cases (e.g., all characters appearing once, one character appearing once while others appear multiple times, etc.). 

Given the constraints ($2 \le \text{word.length} \le 100$), a simulation-based brute-force approach is highly efficient and eliminates edge-case errors.

### 🛠️ The Strategy:
1. **Frequency Table:** Build an initial frequency map of the 26 lowercase English letters.
2. **Try Removals (Simulation):** Iterate through all 26 letters. If a letter is present (count > 0):
   - Temporarily decrement its count by 1 (simulating removal).
   - Check if all other non-zero frequencies in the table are perfectly identical using a helper function `isValid()`.
   - If valid, return `true`.
   - If not, backtrack by incrementing the count back to its original state and move to the next character.
3. **Fallback:** If no single removal results in equal frequencies, return `false`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡) - Building the frequency array takes $O(N)$ where $N$ is the string length. The simulation loop runs a fixed 26 times, and the `isValid` check scans 26 elements, making the simulation phase $O(26 \times 26) = O(1)$.
* **Space Complexity:** 𝙊(𝟭) - The frequency array size is hard-coded to 26 regardless of the input length.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean equalFrequency(String word) {
        byte[] freq = new byte[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Simulate removing one character from each available letter type
        for (byte i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            freq[i]--; // Simulate removal
            if (isValid(freq)) return true;
            freq[i]++; // Backtrack
        }

        return false;
    }

    private boolean isValid(byte[] freq) {
        byte expected = 0;
        for (byte num : freq) {
            if (num == 0) continue;

            if (expected == 0) {
                expected = num; // Establish baseline frequency
            } else if (expected != num) {
                return false; // Found a mismatch
            }
        }
        return true;
    }
}
