import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
//    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Scanner scanner = new Scanner(System.in);

    static WriteThreadWithSynchronizedMethods writeThreadWithSynchronizedMethods;
    static CalculateThreadWithSynchronizedMethods calculateThreadWithSynchronizedMethods;
    static WatchTreadWithSynchronizedMethods watchTreadWithSynchronizedMethods;

    static WriteThreadWithSynchronizedBlocks writeThreadWithSynchronizedBlocks;
    static CalculateThreadWithSynchronizedBlocks calculateThreadWithSynchronizedBlocks;
    static WatchThreadWithSynchronizedBlocks watchThreadWithSynchronizedBlocks;

    static WriteThreadConcurrent writeThreadConcurrent;
    static CalculateThreadConcurrent calculateThreadConcurrent;
    static WatchThreadConcurrent watchThreadConcurrent;

    //for concurrent collections
    static List<Integer> listThreads = new CopyOnWriteArrayList<>();

    //for blocks and methods
//    static List<Integer> listThreads = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("WriteThreads amount:");
        int write = scanner.nextInt();
        System.out.println("CalculateThreads amount:");
        int calculate = scanner.nextInt();

        //concurrent collections
        writeThreadConcurrent = new WriteThreadConcurrent(write, listThreads);
        writeThreadConcurrent.start();
        calculateThreadConcurrent = new CalculateThreadConcurrent(calculate, listThreads);
        calculateThreadConcurrent.start();
        watchThreadConcurrent = new WatchThreadConcurrent(listThreads);
        watchThreadConcurrent.start();

        //synchronized blocks
//        writeThreadWithSynchronizedBlocks = new WriteThreadWithSynchronizedBlocks(write, listThreads);
//        writeThreadWithSynchronizedBlocks.start();
//        calculateThreadWithSynchronizedBlocks = new CalculateThreadWithSynchronizedBlocks(calculate, listThreads);
//        watchThreadWithSynchronizedBlocks = new WatchThreadWithSynchronizedBlocks(listThreads);
//        watchThreadWithSynchronizedBlocks.start();



        //synchronized methods
//        writeThreadWithSynchronizedMethods = new WriteThreadWithSynchronizedMethods(write, listThreads);
//        writeThreadWithSynchronizedMethods.start();
//        calculateThreadWithSynchronizedMethods = new CalculateThreadWithSynchronizedMethods(calculate, listThreads);
//        calculateThreadWithSynchronizedMethods.start();
//        watchTreadWithSynchronizedMethods = new WatchTreadWithSynchronizedMethods(listThreads);
//        watchTreadWithSynchronizedMethods.start();



    }
}
