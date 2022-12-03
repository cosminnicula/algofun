package dev.intermediatebox.multithreading.producerconsumer.simple.mixedlogic;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerQueue {

  private Queue<Integer> queue;
  private int size;

  public ProducerConsumerQueue(int size) {
    this.queue = new LinkedList<>();
    this.size = size;
  }

  // Scenario 1:
  // 1. Producer thread acquires the lock on the current instance of the ProducerConsumerQueue by entering the synchronized block
  //   a. queue size is 0, so it adds the value to the queue, then it notifies any other waiting thread, then it goes to sleep for 1 second, however, it doesn't release the current lock it holds
  //   b. queue size is 1, so it repeats the previous steps
  //   c. queue size is 2, so it waits, which implies releasing the current lock it holds
  // OBS: Between 1. and 2., Producer thread could wake up, again before Consumer thread, but it will immediately go to waiting state, since queue.size() will still be 2
  // 2. Consumer thread being in a waiting state because it couldn't initially acquire the lock (the Producer thread acquired it first), it wakes up at some point, since it was notified, and it acquires the lock on the current instance of the ProducerConsumerQueue by entering the synchronized block
  //   a. queue size is 2, so it removes the value from the queue, then it notifies any other waiting thread, then it goes to sleep for 1 second, however, it doesn't release the current lock it holds
  //   b. queue size is 1, so it repeats the previous steps
  //   c. queue size is 0, so it waits, which implies releasing the current lock it holds
  // 3. Producer thread wakes up at some point, since it was notified, it resumes the execution in the "while (queue.size() >= size)" which implies acquiring the lock again, it exits the while block since queue.size() is 0, and repeats 1.a.

  // Scenario 2:
  // 1. Consumer thread acquires the lock on the current instance of the ProducerConsumerQueue by entering the synchronized block
  //   a. queue size is 0, so it waits, which implies releasing the current lock it holds
  // OBS: Between 1. and 2., Consumer thread could wake up, again, before Producer thread, but it will immediately go to waiting state, since queue.size() will still be 0
  // 2. Producer thread being in a waiting state because it couldn't initially acquire the lock (the Consumer thread acquired it first), it wakes up at some point, since it couldn't start in the first place, and it acquires the lock on the current instance of the ProducerConsumerQueue by entering the synchronized block
  //   a. queue size is 0, so it adds the value to the queue, then it notifies any other waiting thread, then it goes to sleep for 1 second, however, it doesn't release the current lock it holds
  //   b. queue size is 1, so it repeats the previous steps
  //   c. queue size is 2, so it waits, which implies releasing the current lock it holds
  // 3. Consumer thread wakes up at some point, since it was notified, it resumes the execution in the "while (queue.size() == 0)" which implies acquiring the lock again, and it exits the while block since queue.size() is > 0
  //   a. queue size is 2, so it removes the value from the queue, then it notifies any other waiting thread, then it goes to sleep for 1 second, however, it doesn't release the current lock it holds
  //   b. queue size is 1, so it repeats the previous steps
  //   c. queue size is 0, so it waits, which implies releasing the current lock it holds
  // 4. Producer thread wakes up at some point, since it was notified, it resumes the execution in the "while (queue.size() >= size)" which implies acquiring the lock again, it exits the while block since queue.size() is 0, and repeats 2.a.

  public void produce() throws InterruptedException {
    int value = 0;
    while (true) {
      synchronized (this) {
        while (queue.size() >= size) {
          // wait for the consumer
          wait();
        }

        queue.add(value);

        System.out.println(Thread.currentThread().getName() + " produced " + value);

        value++;

        notify();

        Thread.sleep(1000);
      }
    }
  }

  public void consume() throws InterruptedException {
    while (true) {
      synchronized (this) {
        while (queue.size() == 0) {
          // wait for the producer
          wait();
        }

        int value = queue.poll();

        System.out.println(Thread.currentThread().getName() + " consumed " + value);

        notify();

        Thread.sleep(1000);
      }
    }
  }
}