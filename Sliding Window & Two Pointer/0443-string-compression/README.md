
# 443. String Compression (Medium)

## Problem Statement

Given an array of characters `chars`, compress it by replacing each group of consecutive repeating characters with:

- The character itself if it appears only once.
- The character followed by its frequency if it appears more than once.

The compressed result must be stored directly in the input array. Frequencies of 10 or more must be represented using individual digit characters.

Return the length of the compressed array.

The algorithm must use O(1) auxiliary space.

## Intuition & Approach

The key idea is to use two pointers to perform **in-place compression**.

- `index` reads the original character array and identifies groups of consecutive repeating characters.
- `currIndex` tracks the position where compressed characters should be written.

For each group, we count its occurrences and store the character at the current write position.

If the count is greater than one, convert the count into a string and write each digit individually into the array.

Since the write pointer never moves ahead of the read pointer, we can safely modify the input array without losing unprocessed characters.

Finally, return `currIndex`, which represents the length of the compressed array.

## Strategy

1. Initialize the read pointer `index` and write pointer `currIndex` to zero.
2. Traverse the array and identify consecutive groups of identical characters.
3. Count the occurrences of each character.
4. Write the character at the current write position.
5. If its count is greater than one, convert the count to a string and write each digit.
6. Continue until all groups are processed.
7. Return the final write pointer as the compressed length.

## Complexity Analysis

- **Time Complexity:** O(n) - Every character is traversed once, and writing the frequency digits takes O(log n) per group. The total work remains O(n).
- **Space Complexity:** O(1) - The compression is performed in-place using constant auxiliary space. The frequency string contains at most O(log n) characters, which is bounded by the fixed input constraint.

## Java Solution

```java id="c8m4vx"
class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int len = chars.length;
        int currIndex = 0;

        while (index < len) {
            int count = 0;
            char ch = chars[index];

            while (index < len && chars[index] == ch) {
                count++;
                index++;
            }

            chars[currIndex++] = ch;

            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[currIndex++] = digit;
                }
            }
        }

        return currIndex;
    }
}
```

## Key Takeaway

The two-pointer technique allows us to read groups and overwrite the input array safely, achieving in-place string compression without using an additional result array.
