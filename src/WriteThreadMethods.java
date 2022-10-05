import java.util.ArrayList;
import java.util.List;

public class WriteThreadMethods extends Thread{
    private List<Integer> list = new ArrayList<>();
    int max = 100;
    int rnd;


    public WriteThreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);
                rnd = (int) (Math.random() * ++max);
                addRnd(rnd, list);
//                list.add(rnd);
                System.out.println("I'm write " + " and I generate " + rnd);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addRnd(int rnd, List<Integer> list){
        list.add(rnd);
    }
}
