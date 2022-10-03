import java.util.ArrayList;
import java.util.List;

public class WatchTreadMethods extends Thread{
    private List<Integer> list = new ArrayList<>();
//    Thread thread;
//
//    public WatchTreadWithSynchronizedMethods(){}

    public WatchTreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        try{
            Thread.sleep(2000);
//            thread = new WatchTreadWithSynchronizedMethods();
            System.out.println("I'm watch thread " + list.size() + " elements in list");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
