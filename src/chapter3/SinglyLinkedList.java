package chapter3;

/**
 * Created by mishrk3 on 4/8/2016.
 */
public class SinglyLinkedList<E> {

    Node<E> head;

    public void insertInLinkedList(E data, int position) {
        if (null == head && position > 0) {
            System.out.println("List is empty");
            return;
        }
        if (0 != position && position > getLength()) {
            System.out.println("given position is greater then length of list");
            return;
        }
        int k = 0;
        Node<E> p, q, newNode = null;
        newNode = new Node<E>(data, null);
        p = head;
        q = null;
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            while (null != p && k < position) {
                k++;
                q = p;
                p = p.next;
            }
            q.next = newNode;
            newNode.next = p;
        }
    }

    public void deleteFromLinkedList(int position) {
        if (null == head) {
            System.out.println("List is empty...");
            return;
        }
        int k = 0;
        Node<E> p = head, q = null;
        if (position == 1) {
            head = head.next;
            return;
        } else {
            while (null != p && k < position) {
                k++;
                q = p;
                p = p.next;
            }
            if (null == p) {
                System.out.println("Position does not exist...");
            } else {
                q.next = p.next;
            }
        }
    }

    public int getLength() {
        Node<E> p = head;
        int count = 0;
        while (null != p) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(E data) {
        if (null == head) {
            insertInLinkedList(data, 0);
        } else {
            insertInLinkedList(data, getLength());
        }
    }

    public void print() {
        Node<E> p = head;
        while (null != p) {
            System.out.print(p.item + " --> ");
            p = p.next;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.print();
        list.deleteFromLinkedList(2);
        System.out.println("After Deletion....");
        list.print();
    }

}
