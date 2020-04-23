package test;

public class ThreadTest {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 fuck");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        },"t1").start();
        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2 fuck");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2").start();
    }
}
