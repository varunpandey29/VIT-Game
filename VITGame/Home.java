import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton AB, UB, labComplex, audi, game, library;

    public Home() {
        setTitle("Navigation-HOME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setBackground(Color.RED);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        titleLabel = new JLabel("Navigate to desired place");
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 24));
        topPanel.add(titleLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 3, 20, 20));

        AB = createButton("Academic Block", "image\\ab2.jpg");
        AB.setBackground(Color.WHITE);
        UB = createButton("Under Belly", "image\\UB.jpg");
        UB.setBackground(Color.WHITE);
        labComplex = createButton("Immersion", "image\\vitblion.jpg");
        labComplex.setBackground(Color.WHITE);
        audi = createButton("Auditorium", "image\\audi1.jpeg");
        audi.setBackground(Color.WHITE);
        game = createButton("Games", "image\\fgame.jpg");
        game.setBackground(Color.WHITE);
        library = createButton("Library", "image\\library.jpg");
        library.setBackground(Color.WHITE);

        // Add buttons to the center panel
        centerPanel.add(AB);
        centerPanel.add(UB);
        centerPanel.add(labComplex);
        centerPanel.add(audi);
        centerPanel.add(library);
        centerPanel.add(game);

    
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setVisible(true);
    }

    private JButton createButton(String label, String imagePath) {
        JButton button = new JButton();
        button.setActionCommand(label);
        button.addActionListener(this);
        button.setLayout(new BorderLayout());
        
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel textLabel = new JLabel(label, SwingConstants.CENTER);
        textLabel.setFont(new Font("SERIF", Font.BOLD, 16));

        button.add(imageLabel, BorderLayout.CENTER);
        button.add(textLabel, BorderLayout.SOUTH);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "Academic Block":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new classrooms().setVisible(true); 
                    }
                });
                break;
            case "Under Belly":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new FoodOrderGame().setVisible(true); 
                    }
                });
                break;
            case "Immersion":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ImmersionProgram().setVisible(true); 
                    }
                });
                break;
            case "Auditorium":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ClubFrame().setVisible(true); 
                    }
                });
                break;
            case "Games":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Game().setVisible(true);
                    }
                });
                break;
            case "Library":
                dispose(); 
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Library().setVisible(true); 
                    }
                });
                break;
            default:
                break;
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home();
            }
        });
    }
}
