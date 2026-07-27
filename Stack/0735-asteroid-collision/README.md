# 735. Asteroid Collision (Medium)

## 📝 Problem Statement

We are given an array `asteroids` representing asteroids moving in a straight line.

- The **absolute value** of an asteroid represents its size.
- A **positive** value means it is moving to the right.
- A **negative** value means it is moving to the left.

Whenever two asteroids moving in opposite directions collide:

- The smaller asteroid explodes.
- If both have the same size, both explode.
- Asteroids moving in the same direction never collide.

Return the state of the asteroids after all collisions.

---

## 💡 Intuition & Approach

A collision is only possible when a **right-moving asteroid** is followed by a **left-moving asteroid**.

A **Stack** efficiently simulates this process by maintaining the asteroids that have survived so far.

For every asteroid:

- If it is moving to the **right**, simply push it onto the stack since it cannot collide with previous asteroids.
- If it is moving to the **left**, repeatedly compare it with the right-moving asteroid at the top of the stack.
  - If the current asteroid is larger, the smaller right-moving asteroid explodes.
  - If both are equal, both explode.
  - If the right-moving asteroid is larger, the current asteroid is destroyed.

After processing all asteroids, the stack contains the final configuration.

### 🛠️ The Strategy

1. **Traverse the Array**
   - Process each asteroid from left to right.

2. **Handle Right-Moving Asteroids**
   - Push every positive asteroid directly onto the stack.

3. **Resolve Collisions**
   - While the stack's top is moving right and is smaller than the current left-moving asteroid, remove it.
   - If both asteroids have the same size, remove the top asteroid.
   - If the stack becomes empty or its top is moving left, push the current asteroid.

4. **Construct the Result**
   - Pop the remaining asteroids from the stack into the answer array in reverse order.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every asteroid is pushed and popped from the stack at most once.

- **Space Complexity:** **O(n)** - In the worst case, all asteroids remain in the stack.

---

## 💻 Implementation (Java)

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < len; i++) {
            if(asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while(!st.isEmpty() && st.peek() > 0 &&
                      st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }

                if(!st.isEmpty() &&
                   st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] result = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
```
