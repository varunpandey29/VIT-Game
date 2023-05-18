import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class classrooms extends JFrame implements ActionListener {
    private JLabel questionLabel, headLabel, infoLabel;
    private JTextField answerTextField;
    private JButton backButton;
    private JButton submitButton;

    public classrooms() {
        setTitle("Subject Questions Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 500));

        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.RED);
        westPanel.setLayout(new GridLayout(3, 1));

        JButton java = new JButton("Advance Java");
        java.addActionListener(this);
        westPanel.add(java);

        JButton softTest = new JButton("Software Testing");
        softTest.addActionListener(this);
        westPanel.add(softTest);

        JButton emiButton = new JButton("EMI");
        emiButton.addActionListener(this);
        westPanel.add(emiButton);

        add(westPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);

        JPanel headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());

        questionLabel = new JLabel(" ");
        questionLabel.setFont(questionLabel.getFont().deriveFont(Font.BOLD, 20f));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionPanel.setBackground(Color.LIGHT_GRAY);
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        headLabel = new JLabel();
        headLabel.setFont(headLabel.getFont().deriveFont(Font.BOLD, 16f));
        headLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headPanel.setBackground(Color.LIGHT_GRAY);
        headPanel.add(headLabel, BorderLayout.NORTH);

        answerTextField = new JTextField();
        answerTextField.setPreferredSize(new Dimension(300, 30));
        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        questionPanel.add(answerTextField, BorderLayout.CENTER);

        centerPanel.add(questionPanel, BorderLayout.CENTER);

        infoLabel = new JLabel("You have the following subjects in this term. Click on the subjects to attend the class for the same.");
        infoLabel.setFont(infoLabel.getFont().deriveFont(Font.BOLD, 14f));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(infoLabel, BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);
        add(headPanel, BorderLayout.NORTH);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBackground(Color.GRAY);
        add(backButton, BorderLayout.SOUTH);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new classrooms().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        if (sourceButton.getText().equals("Advance Java")) {
            questionLabel.setText("What are the main features of Java?");
            infoLabel.setText("");
            headLabel.setText("Oh! Seems like Rizwan sir has planned for a surprise test! Write the answer for the following question -");
        } else if (sourceButton.getText().equals("Software Testing")) {
            questionLabel.setText("Explain consequences of Bugs");
            infoLabel.setText("");
            headLabel.setText("Oh! Seems like Azra Ma'am has planned for a surprise test! Are You Ready? Write the answer for the following question -");
        } else if (sourceButton.getText().equals("EMI")) {
            questionLabel.setText("Explain the working of RF Oscillator");
            infoLabel.setText("");
            headLabel.setText("Oh! Seems like Narendra sir has planned for a surprise test! Are You Ready? Write the answer for the following question -");
        } else if (sourceButton == backButton) {
            dispose();
            Home home = new Home();
        } else if (sourceButton == submitButton) {
            JOptionPane.showMessageDialog(this, "Your answer has been submitted. You will get the test result in a few days.", "Submission", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
