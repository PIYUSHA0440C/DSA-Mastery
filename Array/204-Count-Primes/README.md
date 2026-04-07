# 204. Count Primes (Medium)

## 📝 Problem Statement
Given an integer `n`, return the number of prime numbers that are strictly less than `n`.

## 💡 Intuition & Approach
To count primes efficiently, we use the **Sieve of Eratosthenes**. Instead of checking if each number is prime, we start from the first prime (2) and mark all of its multiples as "not prime." We repeat this for the next available prime, and so on.

### 🛠️ The Strategy:
1. **Boolean Array:** Create a boolean array `notPrime` of size `n`. By default, all values are `false` (assuming all numbers are prime initially).
2. **Outer Loop:** Iterate from 2 up to `n`.
3. **Prime Check:** If `notPrime[i]` is still `false`, then `i` is a prime number.
   - Increment our `count`.
4. **Marking Multiples:** For every prime `i`, run an inner loop to mark `i*2, i*3, i*4...` as `true` (not prime).
5. **Optimization Tip:** The inner loop can actually start at `i * i` to avoid re-marking multiples already covered by smaller primes.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 𝗹𝗼𝗴 𝗹𝗼𝗴 𝗻) - This is the mathematical complexity of the Sieve of Eratosthenes, which is incredibly close to linear.
* **Space Complexity:** 𝙊(𝗻) - To store the boolean array of size `n`.

## 💻 Implementation (Java)
```java
class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            // If the number is not marked, it's a prime
            if (notPrime[i] == false) {
                count++;
                // Mark all multiples of i as not prime
                // Optimization: j can start from (long)i * i
                for (long j = 2; i * j < n; j++) {
                    notPrime[(int)(i * j)] = true;
                }
            }
        }

        return count;
    }
}
