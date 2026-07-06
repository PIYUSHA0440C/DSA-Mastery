# 1288. Remove Covered Intervals (Medium)

## 📝 Problem Statement
Given an array `intervals` where `intervals[i] = [li, ri]` represent the interval `[li, ri)`, remove all intervals that are covered by another interval in the list.

The interval `[a, b)` is covered by the interval `[c, d)` if and only if `c <= a` and `b <= d`. Return the number of remaining intervals.

## 💡 Intuition & Approach
To efficiently find covered intervals without comparing every pair in $O(N^2)$ time, we use a custom **Sorting & Greedy** strategy.

If we sort intervals primarily by their start time in ascending order, any subsequent interval will automatically satisfy the first condition for being covered (`c <= a`). To handle ties where multiple intervals share the exact same start time, we sort their end times in descending order. This guarantees that the largest, most inclusive interval comes first, allowing it to naturally cover smaller, nested intervals that start at the same position.

After sorting, we perform a single pass through the intervals while maintaining the maximum end time seen so far (`maxEnd`). For each interval:
* If its end time is less than or equal to `maxEnd`, it is completely swallowed or "covered" by a previous interval and should be removed.
* If its end time is strictly greater than `maxEnd`, it cannot be covered. We increment our valid interval count and update `maxEnd` to this new boundary.

### 🛠️ The Strategy:
1. **Custom Sorting:** Sort `intervals` such that if `a[0] == b[0]`, then sort by `b[1] - a[1]` (descending end time). Otherwise, sort by `a[0] - b[0]` (ascending start time).
2. **Track Covered Boundaries:** Initialize `count = 0` and `maxEnd = 0`.
3. **Linear Scan Evaluation:** Loop through each interval. If `interval[1] > maxEnd`, it is a non-covered interval. Increment `count` and shift `maxEnd = interval[1]`.
4. **Return Output:** Return the total count of uncovered remaining intervals.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log N) - The execution time is dominated by sorting the interval pairs array of size $N$. The subsequent loop filters elements in a single linear $O(N)$ pass.
* **Space Complexity:** O(1) or O(log N) - Modifies the input array in place, requiring no extra structural memory allocations beyond standard quicksort recursion stacks.

## 💻 Implementation (Java)
```java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start time ascending; on a tie, sort by end time descending
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            // If the current end extends past maxEnd, it is not covered
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1]; // Update the boundary marker
            }
        }

        return count;
    }
}
