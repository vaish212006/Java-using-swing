package ec3108;

import javax.swing.*;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Exercise 3b:
 * Factorial calculator "applet" as a Swing GUI.
 */
public class Ex03b_FactorialPanel extends JFrame implements Serializable {
	 private static final long serialVersionUID = 1L; // Or a generated value{
    private final JTextField input = new JTextField();
    private final JTextField output = new JTextField();

    public Ex03b_FactorialPanel() {
        super("Factorial Compute");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Enter an integer:"));
        add(input);
        JButton btn = new JButton("Compute");
        btn.addActionListener(e -> compute());
        add(btn);
        add(new JLabel("Result:"));
        output.setEditable(false);
        add(output);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void compute() {
        try {
            int n = Integer.parseInt(input.getText().trim());
            if (n < 0) throw new NumberFormatException("Negative not allowed");
            output.setText(factorial(n).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid non-negative integer.");
        }
    }

    private BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) f = f.multiply(BigInteger.valueOf(i));
        return f;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex03b_FactorialPanel().setVisible(true));
    }
}
