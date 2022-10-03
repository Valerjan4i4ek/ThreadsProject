import java.util.ArrayList;
import java.util.List;

public class CalculateThreadMethods extends Thread{
    private List<Integer> list = new ArrayList<>();
    public  List<Integer> finalList = new ArrayList<>();

    public CalculateThreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run(){
        try {
            Thread.sleep(10);

            System.out.println("I'm calculate ");
            finalList = firstFiveElements(list);
            System.out.println(finalList.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized List<Integer> firstFiveElements(List<Integer> list){
        List<Integer> fiveElementsList = new ArrayList<>();
//        int count = 0;
        if(list != null && !list.isEmpty()){
            if(list.size() >= 5){
                fiveElementsList = list.subList(0, 5);
                fiveElementsList = middleArithmetic(fiveElementsList);

//                middleArithmetic(fiveElementsList);
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(fiveElementsList.get(i) + " ");
//                }
                System.out.println();
            }
        }
        return fiveElementsList;
    }

    public synchronized List<Integer> middleArithmetic(List<Integer> list){
        List<Integer> returnList = new ArrayList<>();
        int count = 0;
        for(int i : list){
            count += i;
        }
        count = count/5;
        for (int i = 0; i < 5; i++) {
//                returnList.set(i, count);
            returnList.add(i, count);
        }
        return returnList;
    }
}
