import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static WriteThreadConcurrent writeThreadConcurrent;
    static CalculateThreadConcurrent calculateThreadConcurrent;
    static WatchThreadConcurrent watchThreadConcurrent;

    //for concurrent collections
    static List<Integer> listConcurrentThreads = new CopyOnWriteArrayList<>();

    //for blocks and methods
    static List<Integer> listThreads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("WriteThreads amount:");
        int write = scanner.nextInt();
        System.out.println("CalculateThreads amount:");
        int calculate = scanner.nextInt();

//        Helper helper = new Helper(write, calculate, listThreads);
//        helper.threadsWorkMethods();
//        helper.threadsWorkBlocks();

        Helper helperConcurrent = new Helper(write, calculate, listConcurrentThreads);
        helperConcurrent.threadsWorkConcurrent();


        


    }
}
