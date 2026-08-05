/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node head = root;

        while(head != null) {
            Node dummy = new Node(0);
            Node curr = dummy;

            while(head != null){
                if(head.left != null){
                    curr.next = head.left;
                    curr = curr.next;
                }

                if(head.right != null){
                    curr.next = head.right;
                    curr = curr.next;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }
}



// /*
// // Definition for a Node.
// class Node {
//     public int val;
//     public Node left;
//     public Node right;
//     public Node next;

//     public Node() {}
    
//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, Node _left, Node _right, Node _next) {
//         val = _val;
//         left = _left;
//         right = _right;
//         next = _next;
//     }
// };
// */
// class Solution {
//     public Node connect(Node root) {
//         if(root == null || (root.left == null && root.right == null)) return root;

//         Deque<Node> initialQueue = new ArrayDeque<>();
//         initialQueue.offerLast(root);
//         dfs(initialQueue);

//         return root;
//     }


//     private void dfs(Deque<Node> queue){
//         if(queue.size() == 0) return;

//         Deque<Node> newQueue = new ArrayDeque<>();

//         while(!queue.isEmpty()){
//             Node temp = queue.poll();
//             if(temp.left != null) newQueue.offerLast(temp.left);
//             if(temp.right != null) newQueue.offerLast(temp.right);
//         }

//         dfs(new ArrayDeque<>(newQueue));

//         if (!newQueue.isEmpty()) {
//             Node curr = newQueue.pop();
//             while(!newQueue.isEmpty()){
//                 Node temp = newQueue.pop();
//                 curr.next = temp;
//                 curr = temp;
//             }
//         }
//     }
// }
