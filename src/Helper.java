import java.util.List;

public class Helper {
    private final int writeAmount;
    private final int calculateAmount;
    private final List<Integer> list;


    public Helper(int writeAmount, int calculateAmount, List<Integer> list) {
        this.writeAmount = writeAmount;
        this.calculateAmount = calculateAmount;
        this.list = list;
    }

    public void threadsWorkBlocks(){

        CalculateThreadBlocks calculateThreadWithSynchronizedBlocks;
        WriteThreadBlocks writeThreadWithSynchronizedBlocks;
        for (int i = 0; i < writeAmount; i++) {
            writeThreadWithSynchronizedBlocks = new WriteThreadBlocks(list);
            writeThreadWithSynchronizedBlocks.start();
        }
        for (int i = 0; i < calculateAmount; i++) {
            calculateThreadWithSynchronizedBlocks = new CalculateThreadBlocks(list);
            calculateThreadWithSynchronizedBlocks.start();
        }
        WatchThreadBlocks watchThreadWithSynchronizedBlocks = new WatchThreadBlocks(list);
        watchThreadWithSynchronizedBlocks.start();
    }

    public void threadsWorkMethods(){
        WatchTreadMethods watchTreadWithSynchronizedMethods = new WatchTreadMethods(list);
        watchTreadWithSynchronizedMethods.start();
        CalculateThreadMethods calculateThreadWithSynchronizedMethods;
        WriteThreadMethods writeThreadWithSynchronizedMethods;
        for (int i = 0; i < writeAmount; i++) {
            writeThreadWithSynchronizedMethods = new WriteThreadMethods(list);
            writeThreadWithSynchronizedMethods.start();
        }
        for (int i = 0; i < calculateAmount; i++) {
            calculateThreadWithSynchronizedMethods = new CalculateThreadMethods(list);
            calculateThreadWithSynchronizedMethods.start();
        }
    }

    public void threadsWorkConcurrent(){
        WriteThreadConcurrent writeThreadConcurrent;
        CalculateThreadConcurrent calculateThreadConcurrent;
        for (int i = 0; i < writeAmount; i++) {
            writeThreadConcurrent = new WriteThreadConcurrent(list);
            writeThreadConcurrent.start();
        }
        for (int i = 0; i < calculateAmount; i++) {
            calculateThreadConcurrent = new CalculateThreadConcurrent(list);
            calculateThreadConcurrent.start();
        }
        WatchThreadConcurrent watchThreadConcurrent = new WatchThreadConcurrent(list);
        watchThreadConcurrent.start();
    }
}
