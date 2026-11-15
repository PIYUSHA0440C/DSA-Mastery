# 451. Sort Characters By Frequency (Medium)

## 📝 Problem Statement

Given a string `s`, sort its characters in decreasing order of frequency.

The frequency of a character is the number of times it appears in the string. Characters with the same frequency can appear in any order, but all occurrences of a character must remain grouped together.

## 💡 Intuition & Approach

Use a `HashMap` to count the frequency of each character and a `PriorityQueue` to process characters in descending order of frequency.

Once the frequencies are calculated, insert all map entries into the max-heap. Repeatedly remove the character with the highest frequency and append it to the result the required number of times.

### 🛠️ The Strategy:

1. Create a `HashMap` to store each character and its frequency.
2. Traverse the input string and update the frequency count.
3. Create a `PriorityQueue` that prioritizes entries with higher frequencies.
4. Add all map entries to the priority queue.
5. Extract entries one by one and append each character according to its frequency using `String.repeat()`.
6. Return the resulting string.

## 📊 Complexity Analysis

Let `n` be the length of the input string and `u` be the number of distinct characters.

- **Time Complexity:** O(n + u log u). Building the frequency map takes O(n), and extracting all entries from the priority queue takes O(u log u). Appending the characters takes O(n).
- **Space Complexity:** O(n + u), including the output string. The frequency map and priority queue require O(u) auxiliary space.

## 💻 Implementation (Java)

\`\`\`java
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }
}
\`\`\`
