package dev.intermediatebox.multithreading.producerconsumer.simple.separatedlogic;

public class ProducerConsumer {
  public static void main(String[] args) throws InterruptedException {
    ProducerConsumerQueue producerConsumerQueue = new ProducerConsumerQueue(2);

    Thread producerThread = new Thread(() -> {
      try {
        int value = 0;
        while (true) {
          producerConsumerQueue.add(value);

          // * What could go wrong if printing to the console here?
          // - just before printing to the console value 0, context switch happens
          // - Consumer thread resumes and prints value 0 to the console, then goes to sleep for 1 second
          // - context switch happens again, and Producer thread resumes and prints value 0
          // This means you'll see the following in the console:
          // - Thread-1 consumed 0
          // - Thread-0 produced 0
          // - Thread-1 consumed 1
          // - Thread-0 produced 1
          // - ...
          // * The reason behind having first "consumed" then "produced" messages in the console is that the code that
          // prints to the console sits outside the synchronized block, which means that the code after
          // producerConsumerQueue.add(value) is not guaranteed to run immediately after, because context switching can happen.
          // System.out.println(Thread.currentThread().getName() + " produced " + value);
          // * By moving the code that prints to the console inside the synchronized block, the problem gets solved.
          // * Another solution would be moving the synchronized block from ProducerConsumerQueue to the Runnable logic, thus
          // making ProducerConsumerQueue not thread-safe
          // * Finally, you could opt out from the implicit locking mechanism (synchronized block), and choose the explicit
          // Lock interface which allows  acquiring the lock in one method and releasing it in another method

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
          int value = producerConsumerQueue.poll();

          // System.out.println(Thread.currentThread().getName() + " consumed " + value);

          Thread.sleep(1000);
        }
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
