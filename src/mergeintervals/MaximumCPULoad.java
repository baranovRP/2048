package mergeintervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        if (jobs == null || jobs.isEmpty()) return 0;
        if (jobs.size() < 2) return jobs.get(0).cpuLoad;

        jobs.sort(Comparator.comparingInt(job -> job.start));
        int maxLoad = 0, currentLoad = 0;
        PriorityQueue<Job> simultaniousJobs = new PriorityQueue<>(Comparator.comparingInt(job -> job.end));
        for (Job job : jobs) {
            while (!simultaniousJobs.isEmpty() && job.start >= simultaniousJobs.peek().end) {
                Job finished = simultaniousJobs.poll();
                currentLoad -= finished.cpuLoad;
            }
            simultaniousJobs.offer(job);
            currentLoad += job.cpuLoad;
            maxLoad = Math.max(maxLoad, currentLoad);
        }
        return maxLoad;
    }

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(N∗logN),
     * where ‘N’ is the total number of jobs.
     * This is due to the sorting that we did in the beginning.
     * Also, while iterating the jobs, we might need to poll/offer jobs to the priority queue.
     * Each of these operations can take O(logN). Overall our algorithm will take O(NlogN).
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N),
     * which is required for sorting.
     * Also, in the worst case,
     * we have to insert all the jobs into the priority queue (when all jobs overlap) which will also take O(N) space.
     * The overall space complexity of our algorithm is O(N).
     */
    public static int findMaxCPULoad1(List<Job> jobs) {
        // sort the jobs by start time
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        int maxCPULoad = 0;
        int currentCPULoad = 0;
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Job job : jobs) {
            // remove all jobs that have ended
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
                currentCPULoad -= minHeap.poll().cpuLoad;

            // add the current job into the minHeap
            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}

