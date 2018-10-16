package chapter10.problems;

public class NutAndBoltMatching {

    public void matchPair(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            final int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivot]);
            matchPair(nuts, bolts, low, pivot - 1);
            matchPair(nuts, bolts, pivot + 1, high);
        }
    }

    private int partition(char[] nuts, int low, int high, char pivot) {
        int left = low;
        int right = high;
        int pivotIdx = getPivotIndex(nuts, pivot);
        if (pivotIdx < 0) {
            System.out.println("There is no right match for: " + pivot + " in: " + nuts.toString());
            return -1;
        }
        while (left < right) {

            while (nuts[left] < pivot && left < right) {
                left++;
            }
            while (nuts[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(nuts, left, right);
            }
        }
        nuts[left] = nuts[right];
        nuts[right] = pivot;
        return right;
    }

    private void swap(char[] nuts, int left, int right) {
        char temp = nuts[left];
        nuts[left] = nuts[right];
        nuts[right] = temp;
    }

    private int getPivotIndex(char[] nuts, char bolt) {
        for (int i = 0; i < nuts.length; i++) {
            if (nuts[i] == bolt) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NutAndBoltMatching nAndB = new NutAndBoltMatching();
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        nAndB.matchPair(nuts, bolts, 0, 5);
        printArray(nuts);
        printArray(bolts);

        System.out.println("--------------------------------------------------------");

        char nuts1[] = {'a', 'e', 'd', 'z', 'l', 'p'};
        char bolts1[] = {'e', 'l', 'z', 'a', 'p', 'd'};
        nAndB.matchPair(nuts1, bolts1, 0, 5);
        printArray(nuts1);
        printArray(bolts1);

        System.out.println("--------------------------------------------------------");

        char nuts2[] = {'1', '9', '7', '3', '4', '2'};
        char bolts2[] = {'9', '2', '4', '7', '1', '3'};
        nAndB.matchPair(nuts2, bolts2, 0, 5);
        printArray(nuts2);
        printArray(bolts2);
    }

    private static void printArray(char[] nuts) {
        for (int i = 0; i < nuts.length; i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println();
    }
}
