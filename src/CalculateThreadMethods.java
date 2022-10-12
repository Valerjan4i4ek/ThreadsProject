import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CalculateThreadMethods extends Thread{
    private static List<Integer> list = new ArrayList<>();

    public CalculateThreadMethods(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);

                System.out.println("I'm calculate ");
                CalculateThreadMethods.firstFiveElements(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void firstFiveElements(List<Integer> list){
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
            }
        }
    }

    public static synchronized void middleArithmetic(List<Integer> list){
        int count = 0;
        if(list != null && !list.isEmpty()){
            if(list.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    count += list.get(i);
                }
                count = count/5;

                ListIterator<Integer> listIterator = list.listIterator();
                int i = 0;
                while (listIterator.hasNext()){
                    if(i == 5){
                        break;
                    }else{
                        listIterator.next();
                        listIterator.remove();
                        i++;
                    }
                }
                list.clear();
                while (listIterator.hasNext()){
                    list.add(listIterator.next());
                }
                list.add(0, count);
            }
        }
    }

}
