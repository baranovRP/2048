package mergeintervals;

import java.util.*;

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int arr1L = arr1.length, arr2L = arr2.length;
        if (arr1L == 0 && arr2L == 0) return new Interval[]{};
        else if (arr1L != 0 && arr2L == 0) return arr1;
        else if (arr1L == 0) return arr2;

        int i = 0, j = 0;
        while (i < arr1L) {
            Interval interval1 = arr1[i];
            while (j < arr2L) {
                Interval interval2 = arr2[j];
                if ((interval1.start <= interval2.end) && (interval2.start <= interval1.end)) {
                    intervalsIntersection.add(
                            new Interval(
                                    Math.max(interval1.start, interval2.start)
                                    , Math.min(interval1.end, interval2.end)));
                }
                j++;
            }
            j = 0;
            i++;
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    /**
     * Time complexity
     * As we are iterating through both the lists once,
     * the time complexity of the above algorithm is O(N+M),
     * where ‘N’ and ‘M’ are the total number of intervals in the input arrays respectively.
     * <p>
     * Space complexity
     * Ignoring the space needed for the result list, the algorithm runs in constant space O(1).
     */
    public static Interval[] merge2(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<Interval>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            // check if the interval arr[i] intersects with arr2[j]
            // check if one of the interval's start time lies within the other interval
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                // store the intersection part
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            // move next from the interval which is finishing first
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }

        return result.toArray(new Interval[result.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}

