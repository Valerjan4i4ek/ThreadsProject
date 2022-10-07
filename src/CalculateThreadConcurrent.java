import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class CalculateThreadConcurrent extends Thread{

//    private List<Integer> list = new CopyOnWriteArrayList<>();
    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    public CalculateThreadConcurrent(Queue<Integer> queue){
        this.queue = queue;
    }

//    public CalculateThreadConcurrent(List<Integer> list){
//
//        this.list = list;
//    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(10);

                System.out.println("I'm calculate ");
//                CalculateThreadConcurrent.firstFiveElements(list);
//                firstFiveElements(list);
                firstFiveElements(queue);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstFiveElements(Queue<Integer> queue){
        if(queue != null && !queue.isEmpty()){
            middleArithmetic(queue);
            if(queue.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    System.out.print(queue.peek() + " ");
                }
            }
            else{
                Queue<Integer> q = new ConcurrentLinkedQueue<>(queue);
                for(Integer i : q){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    public void firstFiveElements(List<Integer> list){
        if(list != null && !list.isEmpty()){
            middleArithmetic(list);
            if(list.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    System.out.print(list.get(i) + " ");
                }
            }
            else{
                List<Integer> fiveElementsList = new CopyOnWriteArrayList<>(list);
                for (Integer integer : fiveElementsList) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        }
    }

    public void middleArithmetic(Queue<Integer> queue){
        int count = 0;
        if(queue != null && !queue.isEmpty()){
            if(queue.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    try{
                        count += queue.poll();
                    } catch (NullPointerException e){

                    }
                }
                count = count/5;
                queue.add(count);
            }
        }
    }

    public void middleArithmetic(List<Integer> list){
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
