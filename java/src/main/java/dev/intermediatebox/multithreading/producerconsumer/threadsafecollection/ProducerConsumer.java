package dev.intermediatebox.multithreading.producerconsumer.threadsafecollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);

    Thread producerThread = new Thread(() -> {
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
    });

    Thread consumerThread = new Thread(() -> {
      try {
        while (true) {
          int value = blockingQueue.take();

          System.out.println(Thread.currentThread().getName() + " consumed " + value);

          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    producerThread.start();
    consumerThread.start();

    producerThread.join();
    consumerThread.join();
  }
}
