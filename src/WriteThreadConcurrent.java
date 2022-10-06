import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WriteThreadConcurrent extends Thread{
    private List<Integer> list = new CopyOnWriteArrayList<>();
    int max = 100;
    int rnd;

    public WriteThreadConcurrent(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);
                rnd = (int) (Math.random() * ++max);
                list.add(rnd);
                System.out.println("I'm write " + " and I generate " + rnd);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
