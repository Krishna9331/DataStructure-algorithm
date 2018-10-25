package chapter17;

import java.util.*;

public class MinimumRoomForSlots {
    /**
     * @param slots the list of meeting slots
     * @return minimum numbers of rooms required for doing these slots
     * <p>
     * We have to find what is max number of overlaps at any particular time, that will be the minimum
     * rooms required to finish all the slots.
     */
    public int findMinimumRoom(List<Slot> slots) {
        int size = slots.size();
        int[] starts = new int[size];
        int[] ends = new int[size];
        for (int i = 0; i < size; i++) {
            starts[i] = slots.get(i).start;
            ends[i] = slots.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        //start from second start time that's why i =1 and room = 1
        int i = 1, j = 0;
        int room = 1, result = 1;
        while (i < size && j < size) {
            if (starts[i] < ends[j]) {
                room++;
                i++;
            } else {
                j++;
                room--;
            }

            if (room > result) {
                result = room;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot(9, 16));
        slots.add(new Slot(9, 10));
        slots.add(new Slot(11, 13));
        slots.add(new Slot(14, 15));
        slots.add(new Slot(9, 13));
        slots.add(new Slot(14, 15));
        slots.add(new Slot(15, 16));
        MinimumRoomForSlots mr = new MinimumRoomForSlots();
        System.out.println("Minimum rooms required: " + mr.findMinimumRoom(slots));

        List<Slot> slots1 = new ArrayList<>();
        slots1.add(new Slot(900, 910));
        slots1.add(new Slot(940, 1200));
        slots1.add(new Slot(950, 1120));
        slots1.add(new Slot(1100, 1130));
        slots1.add(new Slot(1500, 1900));
        slots1.add(new Slot(1800, 2000));
        System.out.println("Minimum rooms: " + mr.findMinimumRoom(slots1));
    }
}

class Slot implements Comparable<Slot> {
    int start;
    int end;

    public Slot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Slot o) {
        return this.start - o.start;
    }
}
