
# 2124. Check if All A's Appears Before All B's (Easy)

## Problem Statement

Given a string `s` containing only the characters `'a'` and `'b'`, determine whether every `'a'` appears before every `'b'`.

Return `true` if the condition is satisfied; otherwise, return `false`.

## Intuition & Approach

The key observation is that once we encounter the first `'b'`, no `'a'` should appear afterward.

We can solve this using a single traversal with two phases:

1. Move through the string until the first `'b'` is found.
2. Continue traversing the remaining characters. If an `'a'` appears, return `false`.

If the second traversal finishes without finding an `'a'`, return `true`.

This also handles strings containing only `'a'` or only `'b'`.

## Strategy

1. Initialize an index at the beginning of the string.
2. Skip all consecutive `'a'` characters until the first `'b'` or the end of the string.
3. Traverse the remaining characters.
4. Return `false` if an `'a'` is encountered.
5. If no such character is found, return `true`.

## Complexity Analysis

- **Time Complexity:** O(n) - Each character is traversed at most once.
- **Space Complexity:** O(1) - Only a constant amount of extra space is used.

## Java Solution

```java
class Solution {
    public boolean checkString(String s) {
        int index = 0;
        int len = s.length();

        while (index < len && s.charAt(index) != 'b') index++;

        while (index < len) {
            if (s.charAt(index) == 'a') return false;
            index++;
        }

        return true;
    }
}
```
