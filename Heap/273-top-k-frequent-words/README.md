# 692. Top K Frequent Words (Medium)

## 📝 Problem Statement

Given an array of strings `words` and an integer `k`, return the `k` most frequent words. Sort the result by frequency in descending order. If two words have the same frequency, sort them in lexicographical order.

## 💡 Intuition & Approach

Use a `HashMap` to count the frequency of each word and a min-heap to keep only the `k` most frequent words.

The heap places words with lower frequencies first. When frequencies are equal, lexicographically larger words come first, so they are removed before smaller words. After processing all unique words, reverse the heap's output to get the required order.

### 🛠️ The Strategy:

1. Count each word's occurrences using a `HashMap`.
2. Create a `PriorityQueue` with a custom comparator based on frequency and lexicographical order.
3. Add each unique word to the min-heap.
4. If the heap size exceeds `k`, remove the word with the lowest priority.
5. Extract the remaining words and reverse the list to obtain the final order.

## 📊 Complexity Analysis

Let `n` be the total number of words and `u` be the number of unique words.

- **Time Complexity:** O(n + u log k + k log k), which simplifies to O(n + u log k) when `k <= u`.
- **Space Complexity:** O(n), for the frequency map and the heap in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String str: words) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }

            return freq.get(a) - freq.get(b);
        });

        for (String word: freq.keySet()) {
            minHeap.add(word);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        ArrayList<String> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        Collections.reverse(result);

        return result;
    }
}
```
