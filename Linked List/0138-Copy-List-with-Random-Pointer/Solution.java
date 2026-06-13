/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node node = dummy;
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp != null){
            Node nextNode = new Node(temp.val);
            node.next = nextNode;
            
            map.put(temp, nextNode);
            
            temp = temp.next;
            node = node.next;
        }

        temp = head;
        node = dummy.next;

        while(temp != null){
            node.random = map.get(temp.random);

            node = node.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
