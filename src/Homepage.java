import java.awt.BorderLayout;

import javax.swing.*;

public class Homepage {
    private JFrame frame;
    private JPanel pane;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Homepage()::createAndShowGui);
    }

    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

        button1 = new JButton("Encryption");
        button2 = new JButton("Decryption");

        pane.add(button1);
        pane.add(new JLabel(new ImageIcon("logo.png")));
        pane.add(button2);

        frame.add(pane, BorderLayout.SOUTH);
        //frame.add(new JLabel(new ImageIcon("logo.png")));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}