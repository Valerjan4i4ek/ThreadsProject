import java.util.ArrayList;
import java.util.List;

public class WatchTread extends Thread{
    private List<Integer> list = new ArrayList<>();

    public WatchTread(){}

    public WatchTread(List<Integer> list){
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
