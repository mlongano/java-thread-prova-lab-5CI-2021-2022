import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
  static public int[] numeri = { 55, 42, 57, 44, 0, 68, 14, 62, 55, 73, 21, 78, 55, 40, 58, 42, 7, 81, 65, 95, 0, 35,
      60, 54, 67, 49, 61, 78, 72, 13, 34, 23, 23, 15, 20, 96, 74, 7, 21, 48, 98, 32, 99, 38, 68, 21, 53, 55, 62, 36, 49,
      80, 84, 76, 38, 16, 73, 62, 89, 29, 75, 56, 64, 5, 89, 63, 2, 13, 79, 27, 53, 76, 21, 28, 94, 13, 73, 35, 82,
      50, 15, 55, 4, 96, 55, 1, 39, 83, 41, 29, 74, 35, 95, 84, 42, 59, 19, 40, 99, 70, 9, 49, 26, 6, 8, 16, 95, 89, 16,
      79, 94, 85, 89, 79, 4, 84, 90, 71, 16, 4, 5, 97, 56, 68, 19, 97, 69, 74, 14, 75, 67, 92, 53, 87, 29, 97, 52, 21,
      37, 6, 11, 6, 51, 96, 27, 16, 49, 45, 22, 41, 95, 29, 82, 68, 92, 40, 95, 22, 83, 58};

  public static void main(String[] args) throws InterruptedException {
    System.out.println("The length of the array is: " + numeri.length);
    int N = 5;
    int size = numeri.length / N;
    CountDownLatch doneSignal = new CountDownLatch(N);
    ExecutorService executor = Executors.newFixedThreadPool(N);

    for (int i = 0; i < N; ++i) {
      System.out.println("Launching thread: " + i + " with size: " + size);
      executor.submit(new WorkerRunnable(doneSignal, i, size));
    }

    doneSignal.await(); // wait for all to finish
    System.out.println("All finished");
  }
}

class WorkerRunnable implements Runnable {
  private final CountDownLatch doneSignal;
  private final int i;
  private final int size;

  WorkerRunnable(CountDownLatch doneSignal, int i, int size) {
    this.doneSignal = doneSignal;
    this.i = i;
    this.size = size;
    System.out.println("Created worker: " + i);
  }

  public void run() {
    doWork(i, size);
    doneSignal.countDown();
    return;
  }

  void doWork(int i, int size) {
    System.out.println("I'm the worker: " + i + " I'm working on: " + (i * size));
    int end = (i*size) + size;
    for (int j = (i * size); j < end; j++) {
      System.out.println("Worker: " + i + ": l'elemento "+j+ " è " + App.numeri[j]);
      System.out.println("Worker: " + i + " I'm doing some work...");
      try {
        Thread.sleep(App.numeri[j]*10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
   }
}