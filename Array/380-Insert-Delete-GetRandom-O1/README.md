# 380. Insert Delete GetRandom O(1) (Medium)

## 📝 Problem Statement
Design a data structure that supports `insert`, `remove`, and `getRandom` operations in average $O(1)$ time complexity.

## 💡 Intuition & Approach
To achieve $O(1)$ for all three operations, we need two data structures working in tandem:
1. **ArrayList:** Stores the actual values. This allows for $O(1)$ access to a random element using a random index.
2. **HashMap:** Maps the `value` to its `index` in the ArrayList. This allows for $O(1)$ lookups to check if a value exists or to find its position for removal.

### 🛠️ The "Swap and Pop" Strategy:
The trickiest part is `remove(val)` in $O(1)$. 
- Standard deletion in an array takes $O(n)$ because all elements to the right must shift left.
- **The Solution:** 1. Find the index of the element to delete using the Map.
  2. Swap that element with the **last** element in the ArrayList.
  3. Update the Map with the new index of the swapped element.
  4. Remove the last element from the list (which is now the value we wanted to delete). This is an $O(1)$ operation as no shifting is required.



## 📊 Complexity Analysis
* **Time Complexity:** Average 𝙊(𝟭) - for all operations.
* **Space Complexity:** 𝙊(𝗻) - To store $n$ elements in both the list and the map.

## 💻 Implementation (Java)
```java
class RandomizedSet {
    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        // Move the last element to the place of the element to delete
        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);
        
        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove);
        
        // Remove the last element from both structures
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
