# 460. LFU Cache (Hard)

## 📝 Problem Statement
Design and implement a data structure for a **Least Frequently Used (LFU)** cache.

Implement the `LFUCache` class:
* `LFUCache(int capacity)` Initializes the object with the capacity of the data structure.
* `int get(int key)` Gets the value of the key if the key exists in the cache. Otherwise, returns `-1`.
* `void put(int key, int value)` Updates the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the **least recently used (LRU)** key would be invalidated.

The functions `get` and `put` must each run in $O(1)$ average time complexity.

## 💡 Intuition & Approach
To achieve $O(1)$ time complexity for all operations in an LFU cache, standard maps or priority queues are insufficient because re-sorting or updating elements takes logarithmic time. Instead, we use a combination of **Hash Maps** and **Doubly Linked Lists (DLL)**.

We group all data cache nodes by their access frequencies. A central hash map maps each frequency count to a unique `DoublyLinkedList` instance. Within each specific frequency list, nodes are ordered by recency—meaning the head tracks the most recently accessed items and the tail holds the least recently accessed items (the LRU element for that frequency). A separate cache map points directly to the list nodes to guarantee constant-time key lookups.

### 🛠️ The Strategy:
1. **Node & List Structures:** Define a custom `Node` that stores the key, value, and its own operational frequency count. Define a `DoublyLinkedList` that handles constant-time sentinel-bounded node additions and tail prunings.
2. **Frequency Elevation Logic:** When an existing key is accessed via `get` or modified via `put`:
   - Extract the target node and remove it from its current frequency group list.
   - If the list becomes empty and its frequency matched our global `minFreq` tracker, increment `minFreq` by 1.
   - Increment the node's individual frequency value, then append it to the head of the list for the new frequency tier.
3. **Eviction and Insertion:** When a new element is added via `put`:
   - If the cache is full, access the list associated with `minFreq` and evict its tail node (the least frequently and least recently used item). Remove this node from the cache map.
   - Create a new node with a base frequency of `1`. Insert it into the frequency list of `1` and update `minFreq = 1`.

## 📊 Complexity Analysis
* **Time Complexity:** O(1) - Node retrievals via the hash map, updates within the doubly linked lists, and eviction pointer rearrangements all execute in strict constant time.
* **Space Complexity:** O(N) - Linear space allocation to retain at most `capacity` elements across our dual hash map indexes and structural doubly linked lists.

## 💻 Implementation (Java)
```java
class Node {
    int key;
    int val;
    Node next;
    Node prev;
    int freq = 1;

    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node v) {
        Node next = head.next;
        head.next = v;
        v.prev = head;
        v.next = next;
        next.prev = v;
    }

    Node removeNode() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    Node removeNode(Node v) {
        Node prev = v.prev;
        Node next = v.next;
        prev.next = next;
        next.prev = prev;
        return v;
    }

    boolean isEmpty() {
        return head.next == tail;
    }
}

class LFUCache {
    HashMap<Integer, DoublyLinkedList> freqList = new HashMap<>();
    HashMap<Integer, Node> lfuCache = new HashMap<>(); 
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
    }
    
    public int get(int key) {
        if (lfuCache.get(key) == null) return -1;
        
        Node v = lfuCache.get(key);
        freqList.get(v.freq).removeNode(v);
        
        if (freqList.get(v.freq).isEmpty()) {
            if (minFreq == v.freq) {
                minFreq = v.freq + 1;
            }
        }
        
        v.freq += 1;
        freqList.computeIfAbsent(v.freq, k -> new DoublyLinkedList()).addNode(v);
        return v.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (lfuCache.get(key) != null) {
            Node v = lfuCache.get(key);
            freqList.get(v.freq).removeNode(v);
            
            if (freqList.get(v.freq).isEmpty()) {
                if (minFreq == v.freq) minFreq = v.freq + 1;
            }
            
            v.freq += 1;
            freqList.computeIfAbsent(v.freq, k -> new DoublyLinkedList()).addNode(v);
            v.val = value;
        } else {
            if (lfuCache.size() == capacity) {
                Node v = freqList.get(minFreq).removeNode();
                lfuCache.remove(v.key);         
            }
            
            Node newNode = new Node(key, value);
            lfuCache.put(key, newNode);
            freqList.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
            minFreq = 1;
        }
    }
}
