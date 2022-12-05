package dev.intermediatebox.multithreading.producerconsumer.semaphore;

import java.util.concurrent.Callable;

public class Producer {

  private final ProducerConsumerQueue buffer;

  Producer(ProducerConsumerQueue buffer) {
    this.buffer = buffer;
  }

  Callable<Boolean> startProducing(int numberOfTasks) {
    return () -> {
      for (int i = 1; i < numberOfTasks; i++) {
        buffer.add(i);
      }
      System.out.println(Thread.currentThread().getName() + " producer exits");
      return true;
    };
  }
}