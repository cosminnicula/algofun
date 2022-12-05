package dev.intermediatebox.multithreading.producerconsumer.semaphore;

import java.util.concurrent.Callable;

class Consumer {
  private final ProducerConsumerQueue buffer;

  Consumer(ProducerConsumerQueue buffer) {
    this.buffer = buffer;
  }

  Callable<Boolean> startConsuming(int numberOfTasks) {
    return () -> {
      for(int i=1; i < numberOfTasks; i++) {
        Integer value = buffer.poll();
        processItem(value);
      }
      System.out.println(Thread.currentThread().getName() + " consumer exits");
      return true;
    };
  }

  private void processItem(Integer item) {
    System.out.println(Thread.currentThread().getName() + " processing item: " + item);
  }
}