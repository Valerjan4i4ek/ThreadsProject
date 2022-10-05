import java.util.ArrayList;
import java.util.List;

public class CalculateThreadMethods extends Thread{
    private List<Integer> list = new ArrayList<>();
//    public  List<Integer> finalList = new ArrayList<>();

    public CalculateThreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);

                System.out.println("I'm calculate ");
                firstFiveElements(list);

//                System.out.println(finalList.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new ArrayList<>();

        if(list != null && !list.isEmpty()){
            list = middleArithmetic(list);
            if(list.size() >= 5){
                fiveElementsList = list.subList(0, 5);

                for (int i = 0; i < 5; i++) {
                    System.out.print(fiveElementsList.get(i) + " ");
                }
                System.out.println();
            }
        }
//        return fiveElementsList;
    }

    public synchronized List<Integer> middleArithmetic(List<Integer> list){
        List<Integer> returnList = new ArrayList<>();

        if(list != null && !list.isEmpty()){
            if(list.size() >= 5){
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    count += list.get(i);
                }

                count = count/5;

//                list.add(0, count);
//                list.subList(1,5).clear();
                returnList.addAll(list);
                List<Integer> subList = returnList.subList(0, 5);
//                returnList.subList(0, 5).clear();
                returnList.removeAll(subList);
                returnList.add(0, count);

//                List<Integer> subList = list.subList(0,5);
//                list.removeAll(subList);
            }
        }
        return returnList;
    }
}
