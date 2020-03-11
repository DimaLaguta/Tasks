package chapter3.ex9ex10;

import java.util.ArrayList;
import java.util.List;

public class Greeter implements Runnable {
    int n;
    String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, " + target);
        }
    }

    public static void runTogether(Runnable... tasks) {
        List<Thread> threads = new ArrayList<>();
        for (Runnable i : tasks) {
            threads.add(new Thread(i));
        }
        threads.forEach(Thread::start);
    }

    public static void runInOrder(Runnable... tasks) {
        List<Thread> threads = new ArrayList<>();
        for (Runnable i : tasks) {
            threads.add(new Thread(i));
        }
        threads.forEach((x) -> x.run());
    }
}
