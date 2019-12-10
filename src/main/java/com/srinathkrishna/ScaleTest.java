package com.srinathkrishna;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScaleTest {
    static int _num_loops_per_thread = 1000000;

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.format("Detected %d cores\n", cores);

        System.out.format("Testing with X threads, each making %d sin(x) calls per thread", _num_loops_per_thread);
        System.out.println("Number of Threads, Milliseconds");
        for (int i = 0; i < 100; i++) {
            List<Thread> threads = new ArrayList<>();
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < i; j++) {
                Thread thread = new Thread(new Work());
                thread.start();
                threads.add(thread);
            }
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                System.err.println("Exception caught!");
                break;
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            System.out.format("%d, %d%n", i+1, duration);
        }

    }
}

class Work implements Runnable
{
    public void run() {
        try {
            for (int i = 0; i < ScaleTest._num_loops_per_thread; i++) {
                int degrees = new Random().nextInt(360);

                // sin() method to get the sine value
                double sinValue = Math.sin(degrees);
            }
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception caught while doing some math");
        }
    }
}
