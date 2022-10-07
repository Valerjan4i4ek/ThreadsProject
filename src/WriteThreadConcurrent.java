import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class WriteThreadConcurrent extends Thread{
//    private List<Integer> list = new CopyOnWriteArrayList<>();
    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    int max = 100;
    int rnd;

    public WriteThreadConcurrent(Queue<Integer> queue){
        this.queue = queue;
    }

//    public WriteThreadConcurrent(List<Integer> list){
//        this.list = list;
//    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);
                rnd = (int) (Math.random() * ++max);
                queue.add(rnd);
                System.out.println("I'm write " + " and I generate " + rnd);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
