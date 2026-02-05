# 657. Robot Return to Origin (Easy)

## 📝 Problem Statement
A robot starts at position `(0, 0)` on a 2D plane. Given a string `moves` containing 'U' (up), 'D' (down), 'L' (left), and 'R' (right), determine if the robot returns to the origin after all moves are completed.

## 💡 Intuition & Approach
The problem is essentially a vector sum. To return to the origin, the net displacement in both the horizontal ($x$) and vertical ($y$) directions must be zero.



### 🛠️ The Strategy:
1. **Initialize Coordinates:** Start with `x = 0` and `y = 0`.
2. **Traverse Moves:** Loop through the `moves` string:
   - 'U' (Up): Increment `y`
   - 'D' (Down): Decrement `y`
   - 'L' (Left): Decrement `x`
   - 'R' (Right): Increment `x`
3. **Check Balance:** After the loop, if `x == 0` and `y == 0`, the robot is back at the start.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We process each move in the string once.
* **Space Complexity:** 𝙊(𝟭) - We only store two integer variables regardless of input size.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        
        for(char ch : moves.toCharArray()) {
            if(ch == 'R') x++;
            else if(ch == 'L') x--;
            else if(ch == 'U') y++;
            else if(ch == 'D') y--;
        }
        
        return x == 0 && y == 0;
    }
}
