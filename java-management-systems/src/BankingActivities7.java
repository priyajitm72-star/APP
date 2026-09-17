import java.util.Random;

class TransactionProcessing implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Processing transaction " + (++count));
            try {
                Thread.sleep(1000); // Simulate processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class BalanceUpdating implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Updating balance " + (++count));
            try {
                Thread.sleep(1500); // Simulate updating time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class SMSNotification implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Sending SMS notification " + (++count));
            try {
                Thread.sleep(2000); // Simulate notification time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class BankingActivities7 {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(new TransactionProcessing());
        Thread balanceThread = new Thread(new BalanceUpdating());
        Thread smsThread = new Thread(new SMSNotification());

        transactionThread.setName("Transaction Processor");
        balanceThread.setName("Balance Updater");
        smsThread.setName("SMS Notifier");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}