package dev.intermediatebox.multithreading.producerconsumer.simple.separatedlogic;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerQueue {
  private Queue<Integer> list;
  private int size;

  public ProducerConsumerQueue(int size) {
    this.list = new LinkedList<>();
    this.size = size;
  }

  public void add(int value) throws InterruptedException {
    synchronized (this) {
      while (list.size() >= size) {
        wait();
      }

      list.add(value);

//      System.out.println(Thread.currentThread().getName() + " produced " + value);

      notify();
    }
  }

  public int poll() throws InterruptedException {
    synchronized (this) {
      while (list.size() == 0) {
        wait();
      }

      int value = list.poll();

//      System.out.println(Thread.currentThread().getName() + " consumed " + value);

      notify();

      return value;
    }
  }
}
