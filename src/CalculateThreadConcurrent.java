import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CalculateThreadConcurrent extends Thread{

    private List<Integer> list = new CopyOnWriteArrayList<>();
//    private List<Integer> list = Collections.synchronizedList(new ArrayList<>());


    public CalculateThreadConcurrent(List<Integer> list){

        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);

                System.out.println("I'm calculate ");
                CalculateThreadConcurrent.firstFiveElements(list);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void firstFiveElements(List<Integer> list){
        if(list != null && !list.isEmpty()){
            middleArithmetic(list);
            if(list.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
            else{
                List<Integer> fiveElementsList = new ArrayList<>(list);
                for (Integer integer : fiveElementsList) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
    }

    public static void middleArithmetic(List<Integer> list){
        List<Integer> subList = new CopyOnWriteArrayList<>();
        int count = 0;
        if(list != null && !list.isEmpty()){
            if(list.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    count += list.get(i);
                }
                count = count/5;

                subList = list.subList(0, 5);
                list.removeAll(subList);
                list.add(0, count);
            }
        }
    }
}
