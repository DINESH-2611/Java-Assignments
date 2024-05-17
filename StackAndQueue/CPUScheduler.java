package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class Job {
    String name;
    int processingTime;
    int priority;

    public Job(String name, int processingTime,int priority) {
        this.name = name;
        this.processingTime = processingTime;
        this.priority=priority;
    }
}

 public class CPUScheduler {
    Queue<Job> queue;
    int waitingTime;
    int turnaroundTime;
    int totalJobs;

    public CPUScheduler() {
        queue = new LinkedList<>();
        waitingTime = 0;
        turnaroundTime = 0;
        totalJobs = 0;
    }

    public void addJob(Job job) {
        queue.add(job);
        totalJobs++;
    }

    public void runScheduler() {
        while (!queue.isEmpty()) {
            Job currentJob = getHighestPriorityJob();
            System.out.println("Processing job: " + currentJob.name);
            waitingTime += totalJobs - 1;
            turnaroundTime += waitingTime + currentJob.processingTime;
            System.out.println("Waiting time: " + waitingTime);
            System.out.println("Turnaround time: " + turnaroundTime);
            totalJobs--;
        }
    }
    private Job getHighestPriorityJob() {
        Job highestPriorityJob = null;
        for (Job job : queue) {
            if (highestPriorityJob == null || job.priority <    highestPriorityJob.priority) {
                highestPriorityJob = job;
            }
        }
        queue.remove(highestPriorityJob);
        return highestPriorityJob;
    }

    public static void main(String[] args) {
        CPUScheduler scheduler = new CPUScheduler();

        scheduler.addJob(new Job("JobA", 5,2));
        scheduler.addJob(new Job("JobB", 3,1));
        scheduler.addJob(new Job("JobC", 2,3));

        scheduler.runScheduler();
    }
}
