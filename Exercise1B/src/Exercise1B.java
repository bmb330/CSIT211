import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by bbraun on 2/5/2015.
 */
public class Exercise1B {
    public static void main(String args[]) {
        String inputFileName = JOptionPane.showInputDialog("Enter Input:");
        FileReader fileName;
        BufferedReader in;

        try {
            fileName = new FileReader(inputFileName);
            in = new BufferedReader(fileName);
            displayText(in);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
    }

    private static void displayText(BufferedReader in) {
        JFrame frame = new JFrame("Exercise 1B");

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textBox = new JTextArea();
        panel.add(new JScrollPane(textBox), BorderLayout.CENTER);


        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400,300);
        frame.setVisible(true);

        String lineFromFile;
        try {
            while ((lineFromFile = in.readLine()) != null) {
                textBox.append(((lineFromFile == "") ? "\n" : lineFromFile+"\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
