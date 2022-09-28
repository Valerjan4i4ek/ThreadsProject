import java.util.ArrayList;
import java.util.List;

public class WatchThreadWithSynchronizedBlocks extends Thread{
    private List<Integer> list = new ArrayList<>();

    public WatchThreadWithSynchronizedBlocks(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        synchronized (list){
            try{
                Thread.sleep(2000);
                System.out.println("I'm watch thread " + list.size() + " elements in list");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
