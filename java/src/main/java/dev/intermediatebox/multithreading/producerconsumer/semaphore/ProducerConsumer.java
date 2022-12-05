package dev.intermediatebox.multithreading.producerconsumer.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// credits to https://turkogluc.com/java-concurrency-producer-consumer
public class ProducerConsumer {
  private static int SIZE = 10;
  private static int NUMBER_OF_TASKS = 10;

  public static void main(String[] args) {
    ProducerConsumerQueue buffer = new ProducerConsumerQueue(SIZE);
    Consumer consumer = new Consumer(buffer);
    Producer producer = new Producer(buffer);

    ExecutorService executorService = Executors.newWorkStealingPool();

    List<Callable<Boolean>> taskList = new ArrayList<>();
    taskList.add(consumer.startConsuming(NUMBER_OF_TASKS));
    taskList.add(producer.startProducing(NUMBER_OF_TASKS));

    try {
      executorService.invokeAll(taskList);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(Thread.currentThread().getName() + " exits");
    }

    executorService.shutdown();
  }
}
