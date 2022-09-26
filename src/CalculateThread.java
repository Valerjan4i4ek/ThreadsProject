import java.util.ArrayList;
import java.util.List;

public class CalculateThread extends Thread{
    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();

    public CalculateThread(){}

    public CalculateThread(int threadsAmount, List<Integer> list){
        this.threadsAmount = threadsAmount;
        this.list = list;
    }

    @Override
    public void run(){
        for (int i = 0; i < threadsAmount; i++) {
            try {
                Thread.sleep(10);
                System.out.println("I'm calculate " + new CalculateThread().getName());

                firstFiveElements(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new ArrayList<>();
        int count = 0;
        if(list != null && !list.isEmpty()){
            if(list.size() >= 5){
                fiveElementsList = list.subList(0, 5);
                for(int i : fiveElementsList){
                    count += i;
                }
                count = count/fiveElementsList.size();
                for (int i = 0; i < 5; i++) {
                    list.set(i, count);
                }
            }
        }
    }
}
