
package ec3108;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Exercise 4:
 * Integer division with proper exception handling and message dialogs.
 */
public class Ex04_IntegerDivision extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L; // Or a generated value
    private final JTextField num1 = new JTextField();
    private final JTextField num2 = new JTextField();
    private final JTextField result = new JTextField();

    public Ex04_IntegerDivision() {
        super("Integer Division");
        setLayout(new GridLayout(4, 2, 5, 5));
        add(new JLabel("Num1:"));
        add(num1);
        add(new JLabel("Num2:"));
        add(num2);
        add(new JLabel("Result:"));
        result.setEditable(false);
        add(result);
        JButton divide = new JButton("Divide");
        divide.addActionListener(e -> divide());
        add(new JLabel()); // spacer
        add(divide);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void divide() {
        try {
            int a = Integer.parseInt(num1.getText().trim());
            int b = Integer.parseInt(num2.getText().trim());
            int r = a / b;
            result.setText(String.valueOf(r));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Number Format Exception: Please enter integers.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Arithmetic Exception: Division by zero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex04_IntegerDivision().setVisible(true));
    }
}
