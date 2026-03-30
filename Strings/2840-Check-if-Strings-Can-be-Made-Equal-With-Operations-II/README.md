# 2840. Check if Strings Can be Made Equal With Operations II (Medium)

## 📝 Problem Statement
You are given two strings `s1` and `s2` of length `n`. You can swap any two characters at indices `i` and `j` as long as $|j - i|$ is even. Return `true` if you can make the strings equal.

## 💡 Intuition & Approach
The condition that $|j - i|$ is even means that characters at even positions can only move to other even positions, and odd positions can only move to other odd positions. 

### 🛠️ The Strategy:
1. **Frequency Counting:** Instead of sorting (which would be $O(N \log N)$), we use frequency arrays ($O(N)$) to check if the character sets match for both parities.
2. **Lane Isolation:** - **Even Lane:** All characters at indices 0, 2, 4...
   - **Odd Lane:** All characters at indices 1, 3, 5...
3. **Difference Tracking:**
   - For every even index `i`, increment the count for `s1[i]` and decrement for `s2[i]`.
   - Do the same for odd indices in a separate array.
4. **Validation:** If the two strings are transformable, all counts in both frequency arrays must return to zero.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the strings once and then perform a constant-time check on the 26-length alphabet arrays.
* **Space Complexity:** 𝙊(𝟭) - We use two arrays of size 26, which is constant regardless of $n$.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] evenCount = new int[26];
        int[] oddCount = new int[26];

        for(int i = 0; i < s1.length(); i++){
            if(i % 2 == 0){
                evenCount[s1.charAt(i) - 'a']++;
                evenCount[s2.charAt(i) - 'a']--;
            } else {
                oddCount[s1.charAt(i) - 'a']++;
                oddCount[s2.charAt(i) - 'a']--;
            }
        }

        // If characters in the same lane match, all counts will be 0
        for(int i = 0; i < 26; i++){
            if(evenCount[i] != 0 || oddCount[i] != 0) return false;
        }

        return true;
    }
}
