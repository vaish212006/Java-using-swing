package ec3108;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Exercise 5:
 * Three-thread app: generator emits a random integer every 1 second.
 * If even -> second thread computes square and prints.
 * If odd  -> third thread computes cube and prints.
 */
public class Ex05_MultiThreadSquareCube {

    static class Generator extends Thread {
        private final BlockingQueue<Integer> evens;
        private final BlockingQueue<Integer> odds;
        private final Random rnd = new Random();

        Generator(BlockingQueue<Integer> evens, BlockingQueue<Integer> odds) {
            this.evens = evens; this.odds = odds;
            setName("Generator");
        }

        @Override public void run() {
            try {
                while (true) {
                    int x = rnd.nextInt(100);
                    System.out.println(getName() + " -> " + x);
                    if (x % 2 == 0) evens.put(x);
                    else odds.put(x);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) { }
        }
    }

    static class SquareWorker extends Thread {
        private final BlockingQueue<Integer> q;
        SquareWorker(BlockingQueue<Integer> q) { this.q = q; setName("SquareWorker"); }
        @Override public void run() {
            try {
                while (true) {
                    int x = q.take();
                    System.out.println(getName() + " square(" + x + ") = " + (x * x));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    static class CubeWorker extends Thread {
        private final BlockingQueue<Integer> q;
        CubeWorker(BlockingQueue<Integer> q) { this.q = q; setName("CubeWorker"); }
        @Override public void run() {
            try {
                while (true) {
                    int x = q.take();
                    System.out.println(getName() + " cube(" + x + ") = " + (x * x * x));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> evens = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> odds  = new LinkedBlockingQueue<>();
        Thread g = new Generator(evens, odds);
        Thread s = new SquareWorker(evens);
        Thread c = new CubeWorker(odds);
        g.start(); s.start(); c.start();

        // Let it run for ~15 seconds then stop
        Thread.sleep(15000);
        g.interrupt(); s.interrupt(); c.interrupt();
    }
}
