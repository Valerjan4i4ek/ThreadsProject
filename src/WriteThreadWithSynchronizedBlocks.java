import java.util.ArrayList;
import java.util.List;

public class WriteThreadWithSynchronizedBlocks extends Thread{
    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;

    public WriteThreadWithSynchronizedBlocks(){}

    public WriteThreadWithSynchronizedBlocks(int threadsAmount, List<Integer> list){
        this.threadsAmount = threadsAmount;
        this.list = list;
    }

    @Override
    public void run(){
        synchronized (list){
            for (int i = 0; i < threadsAmount; i++) {
                try {
                    Thread.sleep(10);
                    rnd = (int) (Math.random() * ++max);
                    list.add(rnd);
                    System.out.println("I'm write " + new WriteThreadWithSynchronizedBlocks().getName() + " and I generate " + rnd);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
