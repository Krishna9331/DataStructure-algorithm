package chapter3;

/**
 * Created by mishrk3 on 4/12/2016.
 */
public class DoublyLinkedList<E> {

    Node<E> head;

    public void insertInDLinkList(E data, int position) {
        Node<E> p = head, temp = null;
        int k = 0;
        Node<E> newNode = new Node<E>(data, null, null);
        if (position == 0) {
            newNode.next = head;
            newNode.previous = null;
            if (null != head) {
                head.previous = newNode;
            }
            head = newNode;
            return;
        } else {
            while (null != p && k < position) {
                k++;
                temp = p;
                p = p.next;
            }
            newNode.next = temp.next;
            newNode.previous = temp;
            if (null != temp.next) {
                temp.next.previous = newNode;
            }
            temp.next = newNode;
            return;
        }


    }

    private static class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    public void deleteFromDLinkList(int position) {
        int k = 0;
        Node<E> p = head, q = null;
        if (position == 0) {
            head = head.next;
            if (null != head)
                head.previous = null;
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
                if (null != p.next) {
                    p.next.previous = p.previous;
                }
                q.next = p.next;
            }
        }
    }

    public void print() {
        Node<E> p = head;
        while (null != p) {
            System.out.print(p.item + " --> ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        dl.insertInDLinkList(3, 0);
        dl.insertInDLinkList(4, 3);
        dl.insertInDLinkList(5, 2);
        dl.insertInDLinkList(6, 0);
        dl.insertInDLinkList(9, 2);
        dl.insertInDLinkList(11, 3);
        dl.print();
        System.out.println();
        System.out.println("After deleting 3rd node: ");
        dl.deleteFromDLinkList(3);
        dl.print();
    }
}
