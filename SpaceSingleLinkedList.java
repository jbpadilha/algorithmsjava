public class SpaceSingleLinkedList {

    Node<T> head;

    SpaceSingleLinkedList () {
        
    }

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int position, T data) {
        Node<T> newNode = new Node<T>(data);
        Node current = head;
        int initialPos = 0;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                if (initialPos == position) {
                    newNode.next = current.next;
                    current.next = newNode;
                } else {
                    current = current.next;
                    initialPos++;
                }
            }
        }
    }



    /*public void insertIf(int position, T data, condition) {
        if (condition()) {

        }
    }*/


}
