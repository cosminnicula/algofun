package dev.intermediatebox.multithreading.producerconsumer.threadsafecollection.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer {
  public static void main(String[] args) {
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
    ExecutorService executor = Executors.newFixedThreadPool(2);

    Runnable producerTask = () -> {
      try {
        int value = 0;
        while (true) {
          blockingQueue.put(value);

          // What could go wrong if printing to the console here?
          // see explanation in dev.intermediatebox.multithreading.producerconsumer.simple.separatedlogic.ProducerConsumer
          System.out.println(Thread.currentThread().getName() + " produced " + value);

          value++;

          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Runnable consumerTask = () -> {
      try {
        while (true) {
          int value = blockingQueue.take();

          System.out.println(Thread.currentThread().getName() + " consumed " + value);

          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    executor.execute(producerTask);
    executor.execute(consumerTask);

    executor.shutdown();
  }
}
