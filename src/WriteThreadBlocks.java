import java.util.ArrayList;
import java.util.List;

public class WriteThreadBlocks extends Thread{
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;

    public WriteThreadBlocks(){}

    public WriteThreadBlocks(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            synchronized (list){
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
}
