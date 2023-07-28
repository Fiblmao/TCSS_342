
/**
 * @author Kian Rivera
 * @version 1.0
 */

public class MyStack<Type> {

    Node head;
    int stackSize;

    private class Node {

        Type item;
        Node next;

        Node(Type item, Node next) {
            this.item = item;
            this.next = next;
        }

        public String toString() {
            return item.toString();
        }
    }

    MyStack() {
        head = null;
        stackSize = 0;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Type item) {
        Node temp = new Node(item, head);
        head = temp;
        stackSize++;

    }

    public Type pop() {
        Type temp = head.item;
        head = head.next;
        stackSize--;

        return temp;
    }

    public Type peek() {
        return head.item;
    }

    public int size() {
        return stackSize;
    }

    public String toString() {
        Node temp = head;
        String content = "[";
        int counter = 0;
        while(temp != null) {
            if (counter != stackSize - 1) {
                content += temp.item + ", ";
            } else {
                content += temp.item + "]";
            }
            temp = temp.next;
            counter++;
        }
        return content;
    }
}