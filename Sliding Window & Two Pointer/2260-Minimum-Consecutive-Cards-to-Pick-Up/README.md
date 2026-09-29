# 2260. Minimum Consecutive Cards to Pick Up (Medium)

## 📝 Problem Statement

Given an integer array `cards`, where `cards[i]` represents the value of the `ith` card, return the minimum number of consecutive cards you have to pick up to contain a pair of matching cards.

If it is impossible to find matching cards, return `-1`.

## 💡 Intuition & Approach

We need to find the smallest distance between two cards having the same value.

A **HashMap** can store the most recent index at which each card value appeared. Whenever the same value appears again, the number of consecutive cards between the two matching cards can be calculated.

### 🛠️ The Strategy:

1. Create a `HashMap` to store the last seen index of each card value.
2. Traverse the array from left to right.
3. If the current card has appeared before:
   - Calculate the number of consecutive cards between the previous occurrence and the current occurrence.
   - Update the minimum count.
4. Store the current index as the latest occurrence of the card.
5. If no matching pair was found, return `-1`.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)` on average.
- **Space Complexity:** `O(n)` in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        int minCards = Integer.MAX_VALUE;

        for(int i = 0; i < cards.length; i++){
            int currentCard = cards[i];

            if(lastSeen.containsKey(currentCard)){
                int distance = i - lastSeen.get(currentCard) + 1;
                minCards = Math.min(minCards, distance);
            }

            lastSeen.put(currentCard, i);
        }

        return minCards == Integer.MAX_VALUE ? -1 : minCards;
    }
}
```
