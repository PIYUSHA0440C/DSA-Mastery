# 933. Number of Recent Calls (Easy)

## 📝 Problem Statement

Implement a `RecentCounter` class that counts the number of requests received within the inclusive time range `[t - 3000, t]`.

The `ping(int t)` method adds a new request at time `t` and returns the total number of requests within the specified range.

Each call to `ping` is guaranteed to have a strictly increasing timestamp.

## 💡 Intuition & Approach

Use an array as a queue with two pointers, `start` and `end`, to maintain the active time window.

Since timestamps arrive in increasing order, outdated requests will always be at the beginning of the queue. Move the `start` pointer forward to discard requests older than 3000 milliseconds, then insert the new timestamp at the `end` position.

The difference between `end` and `start` gives the number of recent requests.

### 🛠️ The Strategy:

1. Initialize `start` and `end` to zero.
2. For every `ping(t)`, check whether the oldest stored timestamp is outside the range `[t - 3000, t]`.
3. Move `start` forward while the oldest request is more than 3000 milliseconds old.
4. Store the current timestamp at `records[end]` and increment `end`.
5. Return `end - start` as the number of recent requests.

## 📊 Complexity Analysis

Let `q` be the total number of calls to `ping`.

- **Time Complexity:** O(1) amortized per `ping`. Each timestamp is inserted once and the `start` pointer moves past each timestamp at most once. Total processing across all calls is O(q).
- **Space Complexity:** O(10⁴), using a fixed-size array to store timestamps, as at most 10⁴ calls are guaranteed.

## 💻 Implementation (Java)

\`\`\`java
class RecentCounter {
    private static final int[] records = new int[10000];
    private int start, end;

    public RecentCounter() {
        start = 0;
        end = 0;
    }

    public int ping(int t) {
        while (start < end && (t - records[start] > 3000)) {
            start++;
        }

        records[end++] = t;
        return end - start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
\`\`\`

**Implementation note:** `records` is declared `static`, so it is shared between all `RecentCounter` instances. The usual LeetCode test usage creates one instance per test case, but using `private final int[] records = new int[10000];` instead makes the storage instance-specific and avoids interference between multiple instances.
