import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WatchThreadConcurrent extends Thread{
    private List<Integer> list = new CopyOnWriteArrayList<>();

    public WatchThreadConcurrent(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("I'm watch thread " + list.size() + " elements in list");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
