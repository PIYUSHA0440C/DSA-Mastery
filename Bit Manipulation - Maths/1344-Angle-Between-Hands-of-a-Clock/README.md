# 1344. Angle Between Hands of a Clock (Medium)

## 📝 Problem Statement
Given two numbers, `hour` and `minutes`, return the smaller angle (in degrees) formed between the hour and the minute hand.

## 💡 Intuition & Approach
The dial of a clock is a perfect circle consisting of $360^{\circ}$ divided into $12$ hours and $60$ minutes. We calculate the absolute position angle of both hands relative to the 12 o'clock benchmark position ($0^{\circ}$) and find their absolute difference.

### 📐 Mathematical Breakdown:
1. **Minute Hand Position:**
   - The minute hand completes a full $360^{\circ}$ rotation in $60$ minutes.
   - Rate: $\frac{360^{\circ}}{60} = 6^{\circ} \text{ per minute}$.
   - Formula: $\text{minutesAngle} = \text{minutes} \times 6$

2. **Hour Hand Position:**
   - The hour hand completes a full $360^{\circ}$ rotation in $12$ hours.
   - Rate per hour: $\frac{360^{\circ}}{12} = 30^{\circ} \text{ per hour}$.
   - The hour hand also moves slightly depending on how many minutes have passed. It covers $30^{\circ}$ in $60$ minutes.
   - Rate per minute: $\frac{30^{\circ}}{60} = 0.5^{\circ} \text{ per minute}$.
   - Formula: $\text{hourAngle} = (30 \times (\text{hour} \pmod{12})) + (0.5 \times \text{minutes})$

3. **Angle Difference Calculation:**
   - Compute the absolute difference: $\text{diff} = |\text{minutesAngle} - \text{hourAngle}|$.
   - A clock forms two interior angles that sum to $360^{\circ}$. Since the problem requests the smaller angle, return $\min(\text{diff}, 360^{\circ} - \text{diff})$.

## 📊 Complexity Analysis
* **Time Complexity:** O(1) - The solution uses basic arithmetic calculations that complete in constant time.
* **Space Complexity:** O(1) - No memory structures are allocated.

## 💻 Implementation (Java)
```java
class Solution {
    public double angleClock(int hour, int minutes) {
        // Each minute accounts for 6 degrees (360 / 60)
        double minutesAngle = minutes * 6;
        
        // Each hour accounts for 30 degrees (360 / 12)
        // Each minute shifts the hour hand by 0.5 degrees (30 / 60)
        double hourAngle = (30 * (hour % 12)) + 0.5 * minutes;

        // Find the absolute difference between both angles
        double diff = Math.abs(minutesAngle - hourAngle);
        
        // Return the smaller interior angle
        return Math.min(diff, 360.0 - diff);
    }
}
