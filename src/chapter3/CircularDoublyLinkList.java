package chapter3;

/**
 * Created by mishrk3 on 4/12/2016.
 */
public class CircularDoublyLinkList<E> {

    Node<E> head;

    public void insertInCLinkList(E data, int position) {
        Node<E> current = head, tmp = current;
        Node<E> newNode = new Node<>(data, null, null);
        if (position == 0) {
            if (null == head) {
                head = newNode;
                newNode.next = newNode;
                return;
            } else {
                while (head != current.next) {
                    current = current.next;
                }
                newNode.next = head;
                current.next = newNode;
                head = newNode;
            }
        } else {
            int k = 0;
            while (head != current.next && k < position) {
                k++;
                tmp = current;
                current = current.next;
            }

            newNode.next = tmp.next;
            newNode.prev = tmp;
            if (null != tmp.next) {
                tmp.next.prev = newNode;
            }
            tmp.next = newNode;
            return;
        }
    }

    public void deleteFromCLinkList(int position) {
        if (null == head) {
            System.out.println("List is empty....");
            return;
        }

        Node<E> current = head, tmp = null;
        int k = 0;
        if (position == 0) {
            if (null != head.next) {
                head.next.prev = head.prev;
                head.prev.next = head.next;
            }
            head = head.next;
        }
        while (head != current.next && k < position) {
            k++;
            tmp = current;
            current = current.next;
        }
        if (head == current.next && k < position) {
            System.out.println("\nposition: " + position + " does not exists...");
        } else {
            tmp.next = current.next;
            if (null != current.next) {
                current.next.prev = tmp;
            }
        }
    }

    public void print() {
        Node<E> current = head;

        do {
            System.out.print(current.item + " --> ");
            current = current.next;
        } while (head != current);
    }


    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkList<Integer> cl = new CircularDoublyLinkList<>();
        cl.insertInCLinkList(5, 0);
        cl.insertInCLinkList(7, 2);
        cl.insertInCLinkList(3, 1);
        cl.insertInCLinkList(9, 1);
        cl.print();
        cl.deleteFromCLinkList(3);
        System.out.println();
        System.out.println("After deleting 2nd pos: ");
        cl.print();
    }
}
