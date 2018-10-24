package chapter17;

import chapter7.Heap;
import chapter7.HeapUtils;

/**
 * Given array F of size n and where f[i] indicated length of ith file, find the minimum cost of merging the file.
 * O(fi, fj) = fi + fj
 */
public class FileMerging {

    /**
     * @param files array of file length
     * @return total cost for merging all the files
     * <p>
     * The logic for below code is always merge the least length files.
     */
    public int mergeFiles(int[] files) {
        int totalCost = 0;
        Heap<Integer> heap = new Heap<>(files.length, "min", Integer.class);
        for (int i = 0; i < files.length; i++) {
            HeapUtils.insertIntoMinHeap(heap, files[i]);
        }
        while (heap.count > 1) {
            int first = HeapUtils.deleteMinHeap(heap);
            int second = HeapUtils.deleteMinHeap(heap);
            int mergeCost = first + second;
            totalCost += mergeCost;
            HeapUtils.insertIntoMinHeap(heap, mergeCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        FileMerging fm = new FileMerging();
        int [] f = {10, 5, 100, 50, 20, 15};
        int cost = fm.mergeFiles(f);
        System.out.println("Total cost: " + cost);
    }
}
