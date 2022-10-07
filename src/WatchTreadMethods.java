import java.util.ArrayList;
import java.util.List;

public class WatchTreadMethods extends Thread{
    private List<Integer> list = new ArrayList<>();

    public WatchTreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("I'm watch thread " + list.size() + " elements in list");
            try{
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
