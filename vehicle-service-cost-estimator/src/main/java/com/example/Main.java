import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceView serviceView = new ServiceView();
            serviceView.setVisible(true);
        });
    }
}