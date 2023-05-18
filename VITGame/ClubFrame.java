import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubFrame extends JFrame implements ActionListener {

    private final String[] technicalImages = {"image\\1.jpg", "image\\2.jpg"};
    private final String[] nonTechnicalImages = {"image\\1684345608584.jpg", "image\\4.jpg"};
    private final String[] regionalImages = {"image\\3.jpg", "image\\1684345608593.jpg"};

    public ClubFrame() {
        setTitle("Upcoming Events List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel descriptionLabel = new JLabel("Upcoming events in college");
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(descriptionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton technicalButton = createStyledButton("Technical Club", technicalImages);
        JButton nonTechnicalButton = createStyledButton("Non-Technical Club", nonTechnicalImages);
        JButton regionalButton = createStyledButton("Regional Club", regionalImages);

        buttonPanel.add(technicalButton);
        buttonPanel.add(nonTechnicalButton);
        buttonPanel.add(regionalButton);

        add(buttonPanel, BorderLayout.CENTER);

        JButton backButton = createStyledButton("Back", null);
        backButton.addActionListener(this);
        backButton.setBackground(Color.GRAY);
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);

        pack();
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String text, String[] images) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 200, 200));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewFrame(text, images);
            }
        });

        return button;
    }

    private void openNewFrame(String clubName, String[] images) {
        JFrame frame = new JFrame(clubName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(5);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);

        ImageIcon image1 = createScaledImageIcon(images[0], 300, 200);
        JLabel imageLabel1 = new JLabel(image1);
        leftPanel.add(imageLabel1);

        ImageIcon image2 = createScaledImageIcon(images[1], 300, 200);
        JLabel imageLabel2 = new JLabel(image2);
        rightPanel.add(imageLabel2);

        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private ImageIcon createScaledImageIcon(String imagePath, int maxWidth, int maxHeight) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        double scaleFactor = Math.min((double) maxWidth / width, (double) maxHeight / height);
        int scaledWidth = (int) (width * scaleFactor);
        int scaledHeight = (int) (height * scaleFactor);

        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        Home home = new Home();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClubFrame();
            }
        });
    }
}
