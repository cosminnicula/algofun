package dev.intermediatebox.multithreading.producerconsumer.simple.mixedlogic;

public class ProducerConsumer {
  public static void main(String[] args) throws InterruptedException {
    ProducerConsumerQueue producerConsumerQueue = new ProducerConsumerQueue(2);

    Thread producerThread = new Thread(() -> {
      try {
        producerConsumerQueue.produce();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread consumerThread = new Thread(() -> {
      try {
        producerConsumerQueue.consume();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    consumerThread.start();
    producerThread.start();


    consumerThread.join();
    producerThread.join();
  }
}
