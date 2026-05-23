package ec3108;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Exercise 7:
 * Traffic light simulator with radio buttons and colored message.
 */
public class Ex07_TrafficLightSimulator extends JFrame implements Serializable {
	 private static final long serialVersionUID = 1L; // Or a generated value
    private final JLabel message = new JLabel("", SwingConstants.CENTER);

    public Ex07_TrafficLightSimulator() {
        super("Traffic Light");
        setLayout(new BorderLayout());

        JPanel choices = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton red = new JRadioButton("Red");
        JRadioButton yellow = new JRadioButton("Yellow");
        JRadioButton green = new JRadioButton("Green");
        bg.add(red); bg.add(yellow); bg.add(green);
        choices.add(red); choices.add(yellow); choices.add(green);

        ActionListener al = e -> {
            if (red.isSelected()) {
                message.setText("Stop");
                message.setForeground(Color.RED);
            } else if (yellow.isSelected()) {
                message.setText("Ready");
                message.setForeground(Color.ORANGE);
            } else if (green.isSelected()) {
                message.setText("Go");
                message.setForeground(Color.GREEN.darker());
            } else {
                message.setText("");
            }
        };
        red.addActionListener(al);
        yellow.addActionListener(al);
        green.addActionListener(al);

        message.setFont(message.getFont().deriveFont(Font.BOLD, 24f));
        add(message, BorderLayout.NORTH);
        add(choices, BorderLayout.CENTER);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex07_TrafficLightSimulator().setVisible(true));
    }
}
