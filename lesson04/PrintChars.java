package Lesson_4.hw;

public class PrintChars {

    private final Object monitor = new Object();
    private volatile char character = 'A';

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (character != 'A') {
                        monitor.wait();
                    }

                    System.out.printf(String.valueOf(character));
                    character = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (character != 'B') {
                        monitor.wait();
                    }

                    System.out.printf(String.valueOf(character));
                    character = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (character != 'C') {
                        monitor.wait();
                    }

                    System.out.printf(String.valueOf(character));
                    character = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        // 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
        // (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

        final PrintChars printChars = new PrintChars();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printChars.printA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printChars.printB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printChars.printC();
            }
        }).start();

    }
}
