import java.util.ArrayList;
import java.util.List;

public class WriteThreadBlocks extends Thread{
//    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;
    Thread thread;

    public WriteThreadBlocks(){}

    public WriteThreadBlocks(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        synchronized (list){
            try {
                Thread.sleep(10);
                rnd = (int) (Math.random() * ++max);
                list.add(rnd);
                thread = new WriteThreadBlocks();
                System.out.println("I'm write " + thread.getName() + " and I generate " + rnd);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
