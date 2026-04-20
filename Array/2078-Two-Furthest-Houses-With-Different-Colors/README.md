# 2078. Two Furthest Houses With Different Colors (Easy)

## 📝 Problem Statement
You are given an array `colors` representing the color of houses on a street. Return the maximum distance $|i - j|$ between two houses $i$ and $j$ that have different colors.

## 💡 Intuition & Approach
The furthest possible distance is between the first house (`index 0`) and the last house (`index n-1`). If they are different colors, we are done. If they are the same color, the optimal pair must involve either the first house or the last house.

### 🛠️ The Strategy:
1. **From the Left:** Compare the first house (`colors[0]`) with houses starting from the end of the array moving backwards. The first house we find with a different color gives the maximum distance from the start.
2. **From the Right:** Compare the last house (`colors[n-1]`) with houses starting from the beginning of the array moving forward. The first house we find with a different color gives the maximum distance from the end.
3. **Result:** The answer is the maximum of these two distances.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We potentially scan the array twice, but in practice, we break as soon as a mismatch is found.
* **Space Complexity:** 𝙊(𝟭) - No extra space used beyond a few integer variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        // Strategy 1: Furthest house from the left end
        for (int i = n - 1; i > 0; i--) {
            if (colors[0] != colors[i]) {
                maxDist = i;
                break;
            }
        }

        // Strategy 2: Furthest house from the right end
        for (int i = 0; i < n; i++) {
            if (colors[n - 1] != colors[i]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
                break;
            }
        }
        
        return maxDist;
    }
}
