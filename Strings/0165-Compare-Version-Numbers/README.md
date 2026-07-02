# 165. Compare Version Numbers (Medium)

## 📝 Problem Statement
Given two version strings, `version1` and `version2`, compare them. A version string consists of revisions separated by dots `'.'`. The value of the revision is its integer conversion ignoring leading zeros.

To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as `0`.

Return the following:
* If `version1 < version2`, return `-1`.
* If `version1 > version2`, return `1`.
* Otherwise, return `0`.

## 💡 Intuition & Approach
Version strings cannot be compared directly as standard strings because character-by-character comparison fails on multi-digit numbers (e.g., `"1.2"` would incorrectly evaluate as greater than `"1.10"` because `'2' > '1'`). Instead, we must parse and compare individual revision segments as integers.

By splitting both strings using the dot delimiter (`\\.`), we break the versions into string arrays. Since the versions might have a different number of segments (e.g., `"1.0"` vs `"1.0.0.0"`), we iterate up to the length of the longer array. For any index that exceeds the bounds of the shorter version array, we greedily default its value to `0`. Converting the string chunks to integers via `Integer.parseInt()` naturally strips out any leading zeros, ensuring an accurate numerical evaluation.

### 🛠️ The Strategy:
1. **Tokenize Input:** Use `.split("\\.")` to parse both version strings into arrays of sub-revisions.
2. **Find Max Bounds:** Determine `maxLength = Math.max(v1.length, v2.length)` to ensure all revisions are fully evaluated.
3. **Padded Array Walk:** Run a loop from index `0` up to `maxLength - 1`. 
   - Extract the revision value at index `i`. If the index is out of bounds for an array, default it to `0`.
   - Parse the chunks to integers to strip leading zeros.
4. **Early Exit Evaluation:** Compare the integer values. If a difference is found, return `1` or `-1` immediately. If the loop completes with all segments matching, return `0`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Splitting both version strings of length $N$ and $M$ takes linear time. The comparison loop runs at most $\max(\text{segments}_1, \text{segments}_2)$ times, executing integer conversions in linear time relative to the segment lengths.
* **Space Complexity:** O(N + M) - Additional string array memory is allocated to hold the split tokens generated from both version strings.

## 💻 Implementation (Java)
```java
class Solution {
    public int compareVersion(String version1, String version2) {
        // Split version components by dot using regex escaping
        String[] v1 = version1.split("\\."); 
        String[] v2 = version2.split("\\."); 
        
        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            // If a version runs out of segments, pad it with 0
            int firstv1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int firstv2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            
            // Compare parsed integer segment values directly
            if (firstv1 < firstv2) {
                return -1;
            } else if (firstv1 > firstv2) {
                return 1;
            }
        }

        // All matched revision levels are structurally equivalent
        return 0;
    }
}
