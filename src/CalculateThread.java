public class CalculateThread extends Thread{
    private int threadsAmount;

    public CalculateThread(){}

    public CalculateThread(int threadsAmount){
        this.threadsAmount = threadsAmount;
    }

    @Override
    public void run(){
        for (int i = 0; i < threadsAmount; i++) {
            System.out.println("I'm calculate " + new CalculateThread().getName());
        }
    }
}
