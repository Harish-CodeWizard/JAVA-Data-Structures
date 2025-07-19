package DS.Stack;

import java.util.PriorityQueue;
import java.util.Comparator;

// Job class with id and priority
class Job {
    int id, priority;

    Job(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

// Comparator to sort Jobs by priority (lower number = higher priority)
class JobComparator implements Comparator<Job> {
    public int compare(Job a, Job b) {
        return a.priority - b.priority; // min priority comes first
    }
}

public class PriorityQ {
    public static void main(String[] args) {
        // Create a PriorityQueue of Jobs using custom comparator
        PriorityQueue<Job> pq = new PriorityQueue<>(new JobComparator());

        // Add some jobs
        pq.add(new Job(1, 10));
        pq.add(new Job(2, 2));
        pq.add(new Job(3, 25));

        System.out.println("\nCustom PriorityQueue output (Job IDs by priority):");
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            System.out.print(job.id + " "); // print job id
        }
        System.out.println(); // for newline
    }
}