package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of n intervals s_i = {start_i, end_i} where 1 <= i <= n, find max subset of s say s' so that no two pair
 * of s' overlaps.
 */
public class IntervalScheduling {

    public List<Schedule> findMaxNonOverlappingSchedule(List<Schedule> schedules) {
        List<Schedule> result = new ArrayList<>();
        Collections.sort(schedules);
        if (schedules.size() == 1) {
            return schedules;
        }
        result.add(schedules.get(0));
        int currEndTime = schedules.get(0).endTime;
        for (int i = 1; i < schedules.size(); i++) {
            if (schedules.get(i).startTime > currEndTime) {
                result.add(schedules.get(i));
                currEndTime = schedules.get(i).endTime;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntervalScheduling is = new IntervalScheduling();
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, 100));
        schedules.add(new Schedule(2, 3));
        schedules.add(new Schedule(4, 5));
        schedules.add(new Schedule(6, 7));
        schedules.add(new Schedule(3, 20));
        List<Schedule> result = is.findMaxNonOverlappingSchedule(schedules);
        System.out.println("Max possible non overlapping schedule: " + result.size());
    }
}

class Schedule implements Comparable<Schedule> {
    int startTime;
    int endTime;

    public Schedule(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Schedule o) {
        return this.endTime - o.endTime;
    }
}