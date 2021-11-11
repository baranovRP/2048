package mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class AllConflictingAppointments {

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(N∗logN),
     * where ‘N’ is the total number of appointments.
     * Though we are iterating the intervals only once, our algorithm will take O(N∗logN)
     * since we need to sort them in the beginning.
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N),
     * which we need for sorting. For Java, Arrays.sort() uses Timsort, which needs O(N) space.
     */
    public static List<Interval[]> canAttendAllAppointments(Interval[] intervals) {
        List<Interval[]> conflicts = new LinkedList<>();
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // find any overlapping appointment
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // please note the comparison above, it is "<" and not "<="
                // while merging we needed "<=" comparison, as we will be merging the two
                // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                // such intervals don't represent conflicting appointments as one starts right
                // after the other
                conflicts.add(new Interval[]{intervals[i], intervals[i - 1]});
            }
        }
        return conflicts;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        List<Interval[]> result = AllConflictingAppointments.canAttendAllAppointments(intervals);
        print(result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = AllConflictingAppointments.canAttendAllAppointments(intervals1);
        print(result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = AllConflictingAppointments.canAttendAllAppointments(intervals2);
        print(result);
    }

    private static void print(List<Interval[]> result) {
        if (result.isEmpty()) System.out.println("There are any conflicts found in your schedule");
        for (Interval[] interval : result) {
            System.out.println(
                    "[" + interval[0].start + "," + interval[0].end + "] "
                    + " and "
                    + "[" + interval[1].start + "," + interval[1].end + "] " + " conflict ");
        }
    }
}

