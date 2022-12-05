package dev.intermediatebox.multithreading.producerconsumer.semaphore;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ProducerConsumerQueue {

  private final Deque<Integer> buffer;
  private final Semaphore consumerSemaphore;
  private final Semaphore producerSemaphore;

  public ProducerConsumerQueue(int size) {
    this.buffer = new LinkedList<>();
    this.consumerSemaphore = new Semaphore(0);
    this.producerSemaphore = new Semaphore(size);
  }

  public void add(Integer value) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " producer wait to get permit");
    producerSemaphore.acquire();
    System.out.println(Thread.currentThread().getName() + " producer got permit");
    System.out.println(Thread.currentThread().getName() + " consumerSemaphore available permits after producerSemaphore.acquire(): " + consumerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " producerSemaphore available permits after producerSemaphore.acquire(): " + producerSemaphore.availablePermits());

    // beginning of critical section
    synchronized (this) {
      System.out.println(Thread.currentThread().getName() + " producer acquired lock. ITEM: " + value);

      buffer.addFirst(value);
      System.out.println(Thread.currentThread().getName() + " producer produced ITEM: " + value);

      System.out.println(Thread.currentThread().getName() + " producer released lock. ITEM: " + value);
    } // end of critical section

    System.out.println(Thread.currentThread().getName() + " consumerSemaphore available permits before consumerSemaphore.release(): " + consumerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " producerSemaphore available permits before consumerSemaphore.release(): " + producerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " producer signal the consumer. ITEM: " + value);
    consumerSemaphore.release();
  }

  public Integer poll() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " consumer wait to get permit");
    consumerSemaphore.acquire();
    System.out.println(Thread.currentThread().getName() + " consumer got permit");
    System.out.println(Thread.currentThread().getName() + " consumerSemaphore available permits after consumerSemaphore.acquire(): " + consumerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " producerSemaphore available permits after consumerSemaphore.acquire(): " + producerSemaphore.availablePermits());

    Integer value;
    // beginning of critical section
    synchronized (this) {
      System.out.println(Thread.currentThread().getName() + " consumer acquired lock");

      value = buffer.removeLast();
      System.out.println(Thread.currentThread().getName() + " consumer consumed ITEM: " + value);

      System.out.println(Thread.currentThread().getName() + " consumer released lock");
    } // end of critical section

    System.out.println(Thread.currentThread().getName() + " consumerSemaphore available permits before producerSemaphore.release(): " + consumerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " producerSemaphore available permits before producerSemaphore.release(): " + producerSemaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " consumer signal the producer. ITEM: " + value);
    producerSemaphore.release();

    return value;
  }
}