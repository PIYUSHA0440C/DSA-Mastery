
# 1352. Product of the Last K Numbers (Medium)

## Problem Statement

Design a data structure that accepts a stream of integers and supports retrieving the product of the last `k` numbers.

Implement the `ProductOfNumbers` class with the following operations:

- `ProductOfNumbers()`: Initializes an empty stream.
- `add(int num)`: Appends an integer to the stream.
- `getProduct(int k)`: Returns the product of the last `k` numbers.

The product of any contiguous sequence is guaranteed to fit within a 32-bit integer.

## Intuition & Approach

The key idea is to use a **prefix product array** to calculate the product of the last `k` numbers in O(1) time.

We initialize the array with `1`, which acts as the base prefix product.

For every non-zero number, we multiply it by the previous prefix product and store the result.

To calculate the product of the last `k` numbers, we divide the latest prefix product by the prefix product before those `k` numbers.

**Handling Zero:**

A zero makes every product containing it equal to zero. To avoid division by zero and prevent zero from affecting future calculations, we clear the prefix product array and reset it to `[1]` whenever zero is added.

If `k` is greater than or equal to the current prefix product array size, the requested range includes a zero, so we return `0`.

## Strategy

1. Initialize a prefix product list with `1`.
2. In `add(num)`, reset the list to `[1]` if `num` is zero.
3. Otherwise, append `num * lastPrefixProduct` to the list.
4. In `getProduct(k)`, check whether `k` is greater than or equal to the list size. If so, return `0`.
5. Otherwise, divide the latest prefix product by the prefix product before the last `k` elements.

## Complexity Analysis

- **Time Complexity:**
  - `add()`: O(1)
  - `getProduct()`: O(1)
- **Space Complexity:** O(n) - Stores prefix products since the most recent zero, where `n` is the number of added non-zero elements in that segment.

## Java Solution

```java
class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            prefixProduct.add(num * prefixProduct.get(prefixProduct.size() - 1));
        }
    }

    public int getProduct(int k) {
        int n = prefixProduct.size();

        if (k >= n) return 0;

        return prefixProduct.get(n - 1) / prefixProduct.get(n - k - 1);
    }
}
```

## Key Takeaway

Prefix products allow range-product queries in O(1) time using division. Resetting the prefix product list whenever zero appears handles zero-containing ranges without requiring special tracking.
