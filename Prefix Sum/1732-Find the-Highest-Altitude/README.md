# 1732. Find the Highest Altitude (Easy)

## 📝 Problem Statement
There is a biker going on a road trip. The road trip consists of `n + 1` points at different altitudes. The biker starts his trip on point `0` with altitude equal `0`. You are given an integer array `gain` of length `n` where `gain[i]` is the net gain in altitude between points `i` and `i + 1`. Return the highest altitude of a point.

## 💡 Intuition & Approach
This problem can be cleanly solved using a **Running Prefix Sum** technique. The altitude at any given point is the cumulative sum of all net gains encountered up to that point.

Instead of generating an auxiliary array to record the absolute altitude at every coordinate, we track the state using a single variable `altitude`. We update this variable sequentially inside a single pass, comparing the results against a global tracker `maxAltitude` to isolate the peak height reached during the trip.

### 🛠️ The Strategy:
1. **Initialize State:** Set `altitude = 0` to match the starting checkpoint value and `maxAltitude = 0` to handle trips that only decrease in height.
2. **Cumulative Iteration:** Run a single loop through `gain`. For each element, add it to `altitude`.
3. **Peak Extraction:** Update `maxAltitude` continuously using `Math.max(maxAltitude, altitude)`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We scan the net gain array exactly once in a linear fashion.
* **Space Complexity:** O(1) - The calculation requires no extra memory storage structures beyond a couple of primitive scalar trackers.

## 💻 Implementation (Java)
```java
class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;

        // Track the cumulative altitude and capture the global peak
        for (int num : gain) {
            altitude += num;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}
