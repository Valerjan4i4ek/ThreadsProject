import java.util.ArrayList;
import java.util.List;

public class WatchTreadWithSynchronizedMethods extends Thread{
    private List<Integer> list = new ArrayList<>();

    public WatchTreadWithSynchronizedMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        try{
            Thread.sleep(2000);
            System.out.println("I'm watch thread " + list.size() + " elements in list");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
