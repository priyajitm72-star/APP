import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceView {
    private JFrame frame;
    private JTextField vehicleRegField;
    private JCheckBox generalServiceCheckBox;
    private JCheckBox oilChangeCheckBox;
    private JCheckBox brakeServiceCheckBox;
    private JCheckBox batteryCheckCheckBox;
    private JButton calculateButton;
    private JLabel resultLabel;

    public ServiceView() {
        frame = new JFrame("Vehicle Service Cost Estimator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        frame.add(new JLabel("Vehicle Registration Number:"));
        vehicleRegField = new JTextField();
        frame.add(vehicleRegField);

        generalServiceCheckBox = new JCheckBox("General Service - ₹1,000");
        frame.add(generalServiceCheckBox);

        oilChangeCheckBox = new JCheckBox("Oil Change - ₹800");
        frame.add(oilChangeCheckBox);

        brakeServiceCheckBox = new JCheckBox("Brake Service - ₹1,200");
        frame.add(brakeServiceCheckBox);

        batteryCheckCheckBox = new JCheckBox("Battery Check - ₹500");
        frame.add(batteryCheckCheckBox);

        calculateButton = new JButton("Calculate Cost");
        frame.add(calculateButton);

        resultLabel = new JLabel("Total Cost: ₹0");
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    public void addCalculateButtonListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }

    public String getVehicleRegNumber() {
        return vehicleRegField.getText();
    }

    public boolean isGeneralServiceSelected() {
        return generalServiceCheckBox.isSelected();
    }

    public boolean isOilChangeSelected() {
        return oilChangeCheckBox.isSelected();
    }

    public boolean isBrakeServiceSelected() {
        return brakeServiceCheckBox.isSelected();
    }

    public boolean isBatteryCheckSelected() {
        return batteryCheckCheckBox.isSelected();
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }
}