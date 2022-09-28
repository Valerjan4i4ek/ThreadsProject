import java.util.ArrayList;
import java.util.List;

public class CalculateThreadWithSynchronizedBlocks extends Thread{
    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();

    public CalculateThreadWithSynchronizedBlocks(){}

    public CalculateThreadWithSynchronizedBlocks(int threadsAmount, List<Integer> list){
        this.threadsAmount = threadsAmount;
        this.list = list;
    }

    @Override
    public void run(){
        synchronized (list){
            for (int i = 0; i < threadsAmount; i++) {
                try {
                    Thread.sleep(10);
                    System.out.println("I'm calculate " + new CalculateThreadWithSynchronizedBlocks().getName());

                    firstFiveElements(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new ArrayList<>();
        int count = 0;
        if(list != null && !list.isEmpty()){
            synchronized (fiveElementsList){
                if(list.size() >= 5){
                    fiveElementsList = list.subList(0, 5);

                    middleArithmetic(count, fiveElementsList);
                    for (int i = 0; i < 5; i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public void middleArithmetic(int count, List<Integer> list){
        synchronized (list){
            for(int i : list){
                count += i;
            }
            count = count/list.size();
            for (int i = 0; i < 5; i++) {
                list.set(i, count);
            }
        }
    }
}
