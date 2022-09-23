import java.util.ArrayList;
import java.util.List;

public class WriteThread extends Thread{
    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;

    public WriteThread(){}

    public WriteThread(int threadsAmount, List<Integer> list){
        this.threadsAmount = threadsAmount;
        this.list = list;
    }

    @Override
    public void run(){
        for (int i = 0; i < threadsAmount; i++) {
            try {
                Thread.sleep(10);
                rnd = (int) (Math.random() * ++max);
                list.add(rnd);
                System.out.println("I'm write " + new WriteThread().getName() + " and I generate " + rnd);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
