# 2515. Shortest Distance to Target String in a Circular Array (Easy)

## 📝 Problem Statement
Given a circular array of strings `words`, a `target` string, and a `startIndex`, find the minimum steps needed to reach the target. You can move left or right, and the array wraps around.

## 💡 Intuition & Approach
In a circular structure, the distance between index $A$ and index $B$ can be measured in two directions. The sum of the clockwise and counter-clockwise distances will always equal the total length of the array $n$.

### 🛠️ The Strategy:
1. **Linear Search:** Iterate through the array to find all indices `i` where `words[i] == target`.
2. **Circular Distance Calculation:**
   - **Clockwise Distance:** `(i - startIndex + n) % n`
   - **Counter-clockwise Distance:** `(startIndex - i + n) % n`
   - Alternatively, once you have one distance $d$, the other is simply $n - d$.
3. **Minimize:** Use a variable `ans` to track the minimum of all calculated distances across all occurrences of the target.
4. **Edge Case:** If the loop finishes and `ans` hasn't been updated, the target doesn't exist; return -1.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string array once.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used beyond a few variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // Distance going forward (right)
                int dist1 = Math.abs(i - startIndex);
                // Distance going backward (left) wrapping around
                int dist2 = n - dist1;
                
                ans = Math.min(ans, Math.min(dist1, dist2));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
