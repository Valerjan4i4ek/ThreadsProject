import javafx.scene.transform.Scale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
//    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Scanner scanner = new Scanner(System.in);
    static WriteThread writeThread;
    static CalculateThread calculateThread;
    static List<Integer> listThreads = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("WriteThreads amount:");
        int write = scanner.nextInt();
        System.out.println("CalculateThreads amount:");
        int calculate = scanner.nextInt();



        while (true){
            writeThread = new WriteThread(write, listThreads);
            writeThread.start();

            calculateThread = new CalculateThread(calculate, listThreads);
            calculateThread.start();

            if(listThreads != null && !listThreads.isEmpty()){
                for(int i : listThreads){
                    System.out.println(i);
                }
            }
            else{
                System.out.println("ololo");
            }
        }

    }
}
