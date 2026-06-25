import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class Task{
    public String name;
    public int priority;

    public Task(){}

    public Task(String name,int priority){
        this.name=name;
        this.priority=priority;
    }


}

public class TaskSchedulerPQ {
     static void scheduleTask(List<Task> task){
        PriorityQueue<Task> pq=new PriorityQueue<>(
                (a,b)->a.priority-b.priority
        );
        for(Task t:task){
            pq.offer(t);
        }
         while (!pq.isEmpty()) {
             Task t = pq.poll();
             System.out.println("Processing: " + t.name);
         }
    }
    public static void main(String[] args) {
        ArrayList<Task> tasks=new ArrayList<>();
        tasks.add(new Task("read about db",1));
        tasks.add(new Task("spring boot p0c",2));
        tasks.add(new Task("leetcode solving",1));
        tasks.add(new Task("mock interview ",3));

        scheduleTask(tasks);


    }
}
