# 575. Distribute Candies (Easy)

## 📝 Problem Statement
Alice has `n` candies (where `n` is always even). There are various types of candies. Alice is advised by her doctor to only eat `n/2` candies. She wants to eat the maximum variety of candy types possible. 

Given an array `candyType`, return the maximum number of different types she can eat.

## 💡 Intuition & Approach
The maximum variety Alice can enjoy is limited by two things: 
1. The total number of unique candy types available.
2. The maximum number of candies she is allowed to eat ($n/2$).

### 🛠️ The Strategy:
1. **Calculate the Limit:** Determine the maximum candies allowed: `limit = candyType.length / 2`.
2. **Track Variety:** Use a `HashSet` to keep track of unique candy types as we iterate through the array.
3. **Greedy Counting:** 
   - Every time we find a *new* candy type (using `set.add(num)`), we increment our count.
   - We stop as soon as we reach either the doctor's limit or we run out of candies to check.
4. **Result:** The count of unique types found within the allowance.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the array once. In the best case (variety reaches limit early), we stop even sooner.
* **Space Complexity:** 𝙊(𝗻) - In the worst case (all candies are different types), the `HashSet` stores $n/2$ elements.

## 💻 Implementation (Java)
```java
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int allowance = candyType.length / 2;
        int uniqueCount = 0;
        
        for (int type : candyType) {
            // set.add returns true if the type is new
            if (set.add(type)) {
                uniqueCount++;
                // Stop once we hit the doctor's limit
                if (uniqueCount == allowance) return uniqueCount;
            }
        }
        
        return uniqueCount;
    }
}
