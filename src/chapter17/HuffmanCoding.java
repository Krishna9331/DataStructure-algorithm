package chapter17;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <pre>
 * The idea behind huffman coding is to use less bit for more frequent character. This helps in data compression, as the
 * character appears most is using less bit. In general we use 8 bit to store a character, however we do not use all bit.
 *
 * The logic for creating huffman Coding is create a BST and try to keep most frequent character close to root. start
 * from root and traverse to character for identifying the bit. Each left movement assign 0 and for each right traversal
 * assign 1.
 *
 * For creating Huffman coding start with two character with least frequency and construct tree with root as sum of the
 * frequency of both character. Continue the process until all character is processed by including root retrieved from
 * previous step as character frequency.
 *
 * Since we have to use least two frequency heap, so we will use minHeap/priorityQueue and do below:
 * 1. Delete two elements.
 * 2. add frequency of above two and insert in heap.
 * 3.
 *
 * </pre>
 */
public class HuffmanCoding {


    private Node huffmanCoding(List<HuffmanCharacter> huffmanChars) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node root = null;
        for (int i = 0; i < huffmanChars.size(); i++) {
            pq.add(new Node(huffmanChars.get(i), null, null));
        }
        for (int i = 0; i < huffmanChars.size() && pq.size() > 1; i++) {
            Node first = pq.poll();
            Node second = pq.poll();
            HuffmanCharacter rootHc = new HuffmanCharacter('$', first.hc.frequency + second.hc.frequency);
            root = new Node(rootHc, first, second);
            pq.add(root);
        }
        printHuffmanCode(root, "");
        return root;
    }

    //PreOrder Traversal
    private void printHuffmanCode(Node root, String code) {
        if(root == null) {
            return;
        }
        if (root.hc.c != '$') {
            System.out.println(root.hc.c + ": " + code);
        }
        if (root.left != null) {
            printHuffmanCode(root.left, code + "0");
        }
        if (root.right != null) {
            printHuffmanCode(root.right, code + "1");
        }
    }

    public static void main(String[] args) {
        HuffmanCharacter hc1 = new HuffmanCharacter('a', 12);
        HuffmanCharacter hc2 = new HuffmanCharacter('b', 2);
        HuffmanCharacter hc3 = new HuffmanCharacter('c', 7);
        HuffmanCharacter hc4 = new HuffmanCharacter('d', 13);
        HuffmanCharacter hc5 = new HuffmanCharacter('e', 14);
        HuffmanCharacter hc6 = new HuffmanCharacter('f', 85);
        HuffmanCoding hfc = new HuffmanCoding();
        hfc.huffmanCoding(Arrays.asList(hc1, hc2, hc3, hc4, hc5, hc6));
    }
}

class HuffmanCharacter implements Comparable<HuffmanCharacter> {
    char c;
    int frequency;

    public HuffmanCharacter(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanCharacter o) {
        return this.frequency - o.frequency;
    }
}

class Node implements Comparable<Node> {
    HuffmanCharacter hc;
    Node left;
    Node right;

    public Node(HuffmanCharacter hc, Node left, Node right) {
        this.hc = hc;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.hc.compareTo(o.hc);
    }
}