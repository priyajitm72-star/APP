public class TrafficManagement7 extends Thread {
    private String junctionName;

    public TrafficManagement7(String junctionName) {
        this.junctionName = junctionName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(junctionName + " reporting traffic status: " + getTrafficStatus());
            try {
                sleep((int) (Math.random() * 2000) + 1000); // Sleep for 1 to 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getTrafficStatus() {
        String[] statuses = {"Light", "Moderate", "Heavy"};
        return statuses[(int) (Math.random() * statuses.length)];
    }

    public static void main(String[] args) {
        TrafficManagement7 junction1 = new TrafficManagement7("Junction 1");
        TrafficManagement7 junction2 = new TrafficManagement7("Junction 2");
        TrafficManagement7 junction3 = new TrafficManagement7("Junction 3");

        junction1.start();
        junction2.start();
        junction3.start();
    }
}