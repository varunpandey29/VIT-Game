import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level1Page extends JFrame implements ActionListener {
    private JButton startButton;
    private ImageIcon backgroundImage;

    public Level1Page() {
        setTitle("Level 1 - CSE 1st Year");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);

        // Set background image
        backgroundImage = new ImageIcon("image\\fmaingate.png");

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create background panel with background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setOpaque(false);

        // Create label panel to hold the labels
        JPanel labelPanel = new JPanel();
        labelPanel.setOpaque(false);
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        // Create top label with "Welcome to" text
        JLabel welcomeLabel = new JLabel("Welcome to");
        welcomeLabel.setFont(new Font("SERIF", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create center label with "VIT BHOPAL University" text
        JLabel titleLabel = new JLabel("VIT BHOPAL University");
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create bottom label with the welcome note
        JLabel welcomeNote = new JLabel("Start the game and enjoy!");
        welcomeNote.setFont(new Font("SERIF", Font.PLAIN, 16));
        welcomeNote.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the labels to the label panel
        labelPanel.add(Box.createVerticalGlue());
        labelPanel.add(welcomeLabel);
        labelPanel.add(titleLabel);
        labelPanel.add(Box.createVerticalGlue());
        labelPanel.add(welcomeNote);
        labelPanel.add(Box.createVerticalGlue());

        // Create button panel for the start button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);

        // Add the components to the main panel
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(backgroundPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            Home home = new Home();
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Level1Page();
            }
        });
    }
}