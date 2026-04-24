# 2833. Furthest Point From Origin (Easy)

## 📝 Problem Statement
You are given a string `moves` consisting of 'L', 'R', and '_'. Starting at 0 on a number line:
- 'L' moves you left (-1).
- 'R' moves you right (+1).
- '_' can be chosen as either 'L' or 'R'.
Return the maximum absolute distance from the origin possible after all moves.

## 💡 Intuition & Approach
To reach the furthest point, we need to maximize our net displacement in one direction. The underscores are flexible, so they should always be used to reinforce the direction we are already leaning towards.

### 🛠️ The Strategy:
1. **Count Everything:** Count the total number of 'L's, 'R's, and '_'s.
2. **Net Distance:** The fixed moves result in a net position of `left - right`. The absolute distance covered by fixed moves is `abs(left - right)`.
3. **Greedy Wildcards:** To maximize this distance, every single underscore should be converted into the direction that increases the absolute value. 
   - If we are further left, make all `_` into 'L'.
   - If we are further right, make all `_` into 'R'.
4. **Formula:** `Result = abs(L - R) + underscores`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the string once to count characters.
* **Space Complexity:** 𝙊(𝟭) - We only store three integer counters.

## 💻 Implementation (Java)
```java
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0;
        int rCount = 0;
        int underscores = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') lCount++;
            else if (ch == 'R') rCount++;
            else underscores++;
        }

        // Net fixed distance + all flexible moves in that same direction
        return Math.abs(lCount - rCount) + underscores;
    }
}
