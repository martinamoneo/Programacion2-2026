package TP5;

// 1.1 Extendiendo Thread
class TareaHilo extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " imprimiendo: " + i);
        }
    }
}

// 1.2 Implementando Runnable
class TareaRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable): " + i);
        }
    }
}
