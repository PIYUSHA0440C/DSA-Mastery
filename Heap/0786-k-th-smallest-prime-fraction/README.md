
# 786. K-th Smallest Prime Fraction (Medium)

## Problem Statement

Given a sorted array `arr` containing `1` and unique prime numbers, consider every fraction `arr[i] / arr[j]` where `0 <= i < j < arr.length`.

Return the `k`-th smallest fraction as an array containing its numerator and denominator.

## Intuition & Approach

The key idea is to use a **PriorityQueue (Max Heap)** to efficiently find the fractions in ascending order.

Instead of generating and sorting all possible fractions, we maintain only the smallest available fraction from each numerator's sequence.

For every numerator `arr[i]`, fractions are initially considered with the largest denominator, `arr[n - 1]`. Since the array is sorted, these fractions are the smallest fractions for their respective numerators.

We use negative fraction values in the priority queue so that Java's max-oriented comparator effectively processes the smallest positive fraction first.

Whenever a fraction is removed from the queue, we move its denominator one position to the left and insert the next fraction from the same numerator, provided the denominator index remains greater than the numerator index.

After removing `k - 1` fractions, the next fraction at the top of the priority queue is the answer.

## Strategy

1. Create a PriorityQueue that orders fractions by their values using negative values and a reverse comparator.
2. Insert the fraction `arr[i] / arr[n - 1]` for every valid numerator index.
3. Remove the smallest fraction from the queue `k - 1` times.
4. For each removed fraction, decrease its denominator index by one.
5. Insert the next fraction if its denominator index is still greater than its numerator index.
6. The fraction remaining at the top is the k-th smallest fraction.
7. Return its numerator and denominator values.

## Complexity Analysis

Let `n` be the length of the array.

- **Time Complexity:** O(n + k log n) - Initializing the priority queue requires O(n log n) with repeated insertions, followed by O(k log n) for removing and inserting fractions. Therefore, the overall bound is O((n + k) log n).
- **Space Complexity:** O(n) - The priority queue stores at most one active fraction for each numerator.

## Java Solution

```java id="k7p2mx"
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length - 1; i++) {
            queue.offer(new double[] {
                -1.0 * arr[i] / arr[arr.length - 1],
                i,
                arr.length - 1
            });
        }

        while (--k > 0) {
            double[] curr = queue.poll();
            int numeratorIndex = (int) curr[1];
            int denominatorIndex = (int) curr[2] - 1;

            if (denominatorIndex > numeratorIndex) {
                queue.offer(new double[] {
                    -1.0 * arr[numeratorIndex] / arr[denominatorIndex],
                    numeratorIndex,
                    denominatorIndex
                });
            }
        }

        double[] result = queue.poll();

        return new int[] {
            arr[(int) result[1]],
            arr[(int) result[2]]
        };
    }
}
```

## Key Takeaway

A priority queue can efficiently merge multiple sorted sequences. Here, each numerator generates a sequence of fractions in ascending order as the denominator moves from right to left. The heap helps retrieve the next smallest fraction without sorting every possible fraction.
