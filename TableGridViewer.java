package ec3108;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Exercise 9:
 * Read a CSV-like text file (comma-separated), first row is header,
 * and display with Labels using GridLayout.
 */
   
public class Ex09_TableGridViewer extends JFrame implements Serializable {
	 private static final long serialVersionUID = 1L; // Or a generated value
    public Ex09_TableGridViewer(List<String[]> rows) {
        super("Table Grid Viewer");
        int cols = rows.get(0).length;
        setLayout(new GridLayout(rows.size(), cols, 5, 5));
        for (int r = 0; r < rows.size(); r++) {
            for (int c = 0; c < cols; c++) {
                JLabel label = new JLabel(rows.get(r)[c], SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                if (r == 0) label.setFont(label.getFont().deriveFont(Font.BOLD));
                add(label);
            }
        }
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static List<String[]> readCSV(String filePath) throws Exception {
        List<String[]> out = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                out.add(line.split("\\s*,\\s*"));
            }
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        String file = args.length > 0 ? args[0] : "Table.txt";
        if (!Files.exists(Path.of(file))) {
            System.err.println("File not found: " + file);
            System.exit(1);
        }
        List<String[]> rows = readCSV(file);
        if (rows.isEmpty()) throw new IllegalArgumentException("Empty file");
        SwingUtilities.invokeLater(() -> new Ex09_TableGridViewer(rows).setVisible(true));
    }
}
