package ec3108;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Exercise 10:
 * Handle all mouse events and show the event name in the center.
 * Uses Adapter classes where appropriate.
 */
public class Ex10_MouseEventsDemo extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L; // Or a generated value 
    private final JLabel center = new JLabel("Do mouse actions here", SwingConstants.CENTER);

    public Ex10_MouseEventsDemo() {
        super("Mouse Events Demo");
        center.setFont(center.getFont().deriveFont(Font.BOLD, 20f));
        center.setPreferredSize(new Dimension(500, 300));
        add(center);

        MouseAdapter adapter = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { show("mouseClicked"); }
            @Override public void mousePressed(MouseEvent e) { show("mousePressed"); }
            @Override public void mouseReleased(MouseEvent e) { show("mouseReleased"); }
            @Override public void mouseEntered(MouseEvent e) { show("mouseEntered"); }
            @Override public void mouseExited(MouseEvent e) { show("mouseExited"); }
            @Override public void mouseDragged(MouseEvent e) { show("mouseDragged"); }
            @Override public void mouseMoved(MouseEvent e) { show("mouseMoved"); }
            private void show(String msg) { center.setText(msg); }
        };
        center.addMouseListener(adapter);
        center.addMouseMotionListener(adapter);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex10_MouseEventsDemo().setVisible(true));
    }
}
