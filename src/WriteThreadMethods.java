import java.util.ArrayList;
import java.util.List;

public class WriteThreadMethods extends Thread{
//    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;
//    Thread thread;
//
//    public WriteThreadWithSynchronizedMethods(){}

    public WriteThreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        try {
            Thread.sleep(10);
//            thread = new WriteThreadWithSynchronizedMethods();
            rnd = (int) (Math.random() * ++max);
            list.add(rnd);
            System.out.println("I'm write " + /*+ thread.getName() + */" and I generate " + rnd);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
