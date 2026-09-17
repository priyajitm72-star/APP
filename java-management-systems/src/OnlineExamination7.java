import java.util.concurrent.TimeUnit;

class RemainingTime implements Runnable {
    public void run() {
        for (int i = 3; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": Remaining time is " + i + " minutes.");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class AutoSave implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": Auto-saving answers... " + i);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class NetworkCheck implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": Checking network connection... " + i);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class OnlineExamination7 {
    public static void main(String[] args) {
        Thread timerThread = new Thread(new RemainingTime());
        Thread autoSaveThread = new Thread(new AutoSave());
        Thread networkCheckThread = new Thread(new NetworkCheck());

        timerThread.setName("Timer Thread");
        autoSaveThread.setName("AutoSave Thread");
        networkCheckThread.setName("Network Check Thread");

        timerThread.start();
        autoSaveThread.start();
        networkCheckThread.start();
    }
}