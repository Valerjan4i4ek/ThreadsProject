import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class WatchThreadConcurrent extends Thread{
//    private List<Integer> list = new CopyOnWriteArrayList<>();
    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    public WatchThreadConcurrent(Queue<Integer> queue){
        this.queue = queue;
    }

//    public WatchThreadConcurrent(List<Integer> list){
//        this.list = list;
//    }

    @Override
    public void run(){
        System.out.println("I'm watch thread " + queue.size() + " elements in list");
        while (!Thread.currentThread().isInterrupted()){
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
