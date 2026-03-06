# 1784. Check if Binary String Has at Most One Segment of Ones (Easy)

## 📝 Problem Statement
Given a binary string `s` (which always starts with '1'), return `true` if it contains at most one contiguous segment of ones. Return `false` otherwise.

## 💡 Intuition & Approach
Since the string is guaranteed to start with '1', any "second" segment of ones would be separated from the first segment by at least one '0'. 

### 🛠️ The Strategy:
1. **Trailing Zeros:** Start from the end of the string and skip all '0's. This moves our pointer to the end of the *last* possible segment of ones.
2. **The Contiguous Check:** Continue scanning backwards from that point. If we encounter a '0' while expecting only '1's (as we move toward the guaranteed '1' at index 0), it means there is a gap, and thus multiple segments exist.
3. **Early Exit:** If we see a '0' during the second phase, return `false`. Otherwise, if we reach the beginning successfully, return `true`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - In the worst case, we traverse the string once.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean checkOnesSegment(String s) {
        int i = s.length() - 1;
        
        // Phase 1: Skip trailing zeros from the right
        while(i >= 0 && s.charAt(i) == '0'){
            i--;
        }

        // Phase 2: Check if the remaining part is strictly ones
        while(i >= 0){
            if(s.charAt(i) == '0') return false;
            i--;
        }

        return true;
    }
}
