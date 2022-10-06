import java.util.ArrayList;
import java.util.List;

public class CalculateThreadBlocks extends Thread{
    private List<Integer> list = new ArrayList<>();


    public CalculateThreadBlocks(){}

    public CalculateThreadBlocks(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            synchronized (list){
                try {
                    Thread.sleep(10);

                    System.out.println("I'm calculate ");

                    firstFiveElements(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new ArrayList<>();
        if(list != null && !list.isEmpty()){
            synchronized (list){
                middleArithmetic(list);
                if(list.size() >= 5){
                    fiveElementsList = list.subList(0, 5);

                    for (int i = 0; i < 5; i++) {
                        System.out.print(fiveElementsList.get(i) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public void middleArithmetic(List<Integer> list){
        List<Integer> subList = new ArrayList<>();
        int count = 0;
        synchronized (list){
            if(list.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    count += list.get(i);
                }

                count = count/5;

                subList = list.subList(0,5);
                list.removeAll(subList);

                list.add(0, count);
            }
        }
    }
}
