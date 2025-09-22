public class LRU_Cache_146 {

    private static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node head, tail;

    public void insertAfterHead(Node node) {
        if (head == null) return;

        Node firstRealNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = firstRealNode;
        firstRealNode.prev = node;
    }

    public void deleteANode(Node node) {
        if (head == null || node == head || node == tail) {
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        insertAfterHead(node);
    }

    public LRU_Cache_146(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }

    public static void main(String[] args) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;


    }
}
