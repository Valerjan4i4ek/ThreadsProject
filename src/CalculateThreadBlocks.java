import java.util.ArrayList;
import java.util.List;

public class CalculateThreadBlocks extends Thread{
//    private int threadsAmount;
    private List<Integer> list = new ArrayList<>();
    Thread thread;

    public CalculateThreadBlocks(){}

    public CalculateThreadBlocks(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        synchronized (list){
            try {
                Thread.sleep(10);
                thread = new CalculateThreadBlocks();
                System.out.println("I'm calculate " + thread.getName());

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
            synchronized (fiveElementsList){
                if(list.size() >= 5){
                    fiveElementsList = list.subList(0, 5);

                    middleArithmetic(count, fiveElementsList);
                    for (int i = 0; i < 5; i++) {
                        System.out.print(fiveElementsList.get(i) + " ");
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
