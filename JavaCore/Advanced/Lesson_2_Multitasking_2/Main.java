package Lesson_4;

public class Main {
    static final Object monitor = new Object();
    static volatile int currentNumber = 1;
    static int numberOfLoop = 5;

    public static void main(String[] args) {

        new Thread(()->{
            try {
            for (int i = 0; i < numberOfLoop; i++) {
                synchronized (monitor) {
                    while (currentNumber != 1) {
                            monitor.wait();
                        }
                    System.out.print("A");
                    currentNumber = 2;
                    monitor.notifyAll();
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (int i = 0; i < numberOfLoop; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 2) {
                            monitor.wait();
                        }
                        System.out.print("B");
                        currentNumber = 3;
                        monitor.notifyAll();
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (int i = 0; i < numberOfLoop; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 3) {
                            monitor.wait();
                        }
                        System.out.print("C");
                        currentNumber = 1;
                        monitor.notifyAll();
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
