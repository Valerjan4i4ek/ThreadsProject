import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WriteThreadConcurrent extends Thread{
//    private int threadsAmount;
    private List<Integer> list = new CopyOnWriteArrayList<>();
    int max = 100;
    int rnd;
//    Thread thread;
//
//    public WriteThreadConcurrent(){}

    public WriteThreadConcurrent(List<Integer> list){
//        this.threadsAmount = threadsAmount;
        this.list = list;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(10);
            rnd = (int) (Math.random() * ++max);
            list.add(rnd);
//            thread = new WriteThreadConcurrent();
            System.out.println("I'm write " + " and I generate " + rnd);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
