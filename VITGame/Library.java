import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Library extends JFrame {

    private JButton dsaButton;
    private JButton osButton;
    private JButton advanceJavaButton;
    private JButton computerNetworksButton;
    private JButton dbmsButton;
    private JButton backButton;

    public Library() {
        setTitle("Library Visiting Frame");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to the Library!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1));

        dsaButton = createSubjectButton("DSA", "https://www.cs.bham.ac.uk/~jxb/DSA/dsa.pdf");
        osButton = createSubjectButton("OS", "https://ebooks.lpude.in/computer_application/mca/term_1/DCAP403_OPERATING_SYSTEM.pdf");
        advanceJavaButton = createSubjectButton("Advanced Java", "https://enos.itcollege.ee/~jpoial/allalaadimised/reading/Advanced-java.pdf");
        computerNetworksButton = createSubjectButton("Computer Networks", "https://csc-knu.github.io/sys-prog/books/Andrew%20S.%20Tanenbaum%20-%20Computer%20Networks.pdf");
        dbmsButton = createSubjectButton("DBMS", "https://mrcet.com/downloads/digital_notes/ECE/III%20Year/DATABASE%20MANAGEMENT%20SYSTEMS.pdf");
        backButton = createBackButton();

        buttonPanel.add(dsaButton);
        buttonPanel.add(osButton);
        buttonPanel.add(advanceJavaButton);
        buttonPanel.add(computerNetworksButton);
        buttonPanel.add(dbmsButton);

        JPanel spacerPanel = new JPanel();
        spacerPanel.setPreferredSize(new Dimension(0, 20)); // Adjust the height of the spacer
        buttonPanel.add(spacerPanel);

        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createSubjectButton(String subject, final String ebookUrl) {
        JButton button = new JButton(subject);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(ebookUrl));
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return button;
    }

    private JButton createBackButton() {
        JButton button = new JButton("Back");
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the back button action here (e.g., navigate back to the homepage)
                Home home = new Home();
                dispose();
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Library frame = new Library();
                frame.setVisible(true);
            }
        });
    }
}