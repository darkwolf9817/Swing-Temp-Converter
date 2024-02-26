import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TempConvert extends JFrame {
    private JComboBox cbxTempIn;
    private JComboBox cbxTempOut;
    private JTextField txtTempIn;
    private JButton btnConvert;
    private JLabel lblOut;
    public JPanel mainPanel;

    ArrayList<String> units = new ArrayList<String>(List.of("Fahrenheit", "Celsius", "Kelvin"));


    public TempConvert() {
        getContentPane().add(mainPanel);

        for (String unit : units) {
            cbxTempIn.addItem(unit);
            cbxTempOut.addItem(unit);
        }

        btnConvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inUnit = cbxTempIn.getSelectedItem().toString();
                String outUnit = cbxTempOut.getSelectedItem().toString();
                double tempIn = Double.parseDouble(txtTempIn.getText());

                double convertedTemp = convert(inUnit, outUnit, tempIn);
                lblOut.setText("Converted temp: " + convertedTemp + " degrees " + outUnit);
            }
        });
    }
    protected double convert(String fromUnit, String toUnit, double tempIn) {
        double result = 0;
        switch(fromUnit) {
            case "Fahrenheit":
                if (toUnit.equals("Celsius")) {
                    result = (tempIn - 32) * 5 / 9;
                } else if (toUnit.equals("Kelvin")) {
                    result = ((tempIn - 32) * 5 / 9) + 273.15;
                } else {
                    result = tempIn;
                }
                break;
            case "Celsius":
                if (toUnit.equals("Fahrenheit")) {
                    result = (tempIn * 9 / 5) + 32;
                } else if (toUnit.equals("Kelvin")) {
                    result = tempIn + 273.15;
                } else {
                    result = tempIn;
                }
                break;
            case "Kelvin":
                if (toUnit.equals("Fahrenheit")) {
                    result = (tempIn - 273.15) * 9.0f / 5.0f + 32.0f;
                } else if (toUnit.equals("Celsius")) {
                    result = tempIn - 273.15;
                } else {
                    result = tempIn;
                }
                break;
            default:
                result = tempIn;
        }
        return result;
    }
}
