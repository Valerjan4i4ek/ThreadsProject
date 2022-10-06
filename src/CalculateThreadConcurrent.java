import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CalculateThreadConcurrent extends Thread{

    private List<Integer> list = new CopyOnWriteArrayList<>();
    private List<Integer> finalList = new CopyOnWriteArrayList<>();

    public CalculateThreadConcurrent(List<Integer> list){

        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);

                System.out.println("I'm calculate ");
                finalList = firstFiveElements(list);
                System.out.println(finalList.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Integer> firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new CopyOnWriteArrayList<>();
//        int count = 0;
        if(list != null && !list.isEmpty()){
            middleArithmetic(list);
            if(list.size() >= 5){
                fiveElementsList = list.subList(0, 5);
//                fiveElementsList = middleArithmetic(fiveElementsList);

//                middleArithmetic(fiveElementsList);
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(fiveElementsList.get(i) + " ");
//                }
//                System.out.println();
            }
        }
        return fiveElementsList;
    }

    public void middleArithmetic(List<Integer> list){
        List<Integer> returnList = new CopyOnWriteArrayList<>();
        int count = 0;
        if(list.size() >= 5){
            for (int i = 0; i < 5; i++) {
                count += list.get(i);
            }
            count = count/5;

            returnList.addAll(list);
            List<Integer> subList = returnList.subList(0, 5);
            returnList.removeAll(subList);
            returnList.add(0, count);
        }

//        for(int i : list){
//            count += i;
//        }
//        count = count/5;
//        for (int i = 0; i < 5; i++) {
//            returnList.add(i, count);
//        }
//        return returnList;
    }
}
