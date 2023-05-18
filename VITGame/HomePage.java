import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {
    private JLabel title, name, reg;
    private JTextField uf, rf;
    private JButton start, exit;

    public HomePage() {
        setTitle("Game Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(37, 150, 200));
        p1.setPreferredSize(new Dimension(100, 120));

        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        title = new JLabel("Welcome to the VIT Game!");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        p.add(title, gbc);

        name = new JLabel("Name :");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 5);
        p.add(name, gbc);

        uf = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 10);
        p.add(uf, gbc);

        reg = new JLabel("Registration:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 5);
        p.add(reg, gbc);

        rf = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 10);
        p.add(rf, gbc);

        start = new JButton("Start");
        start.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 5);
        p.add(start, gbc);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 5, 10, 10);
        p.add(exit, gbc);
        

      
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\VARUN PANDEY\\Desktop\\vitlogo.png");
        Image image = imageIcon.getImage();
        int width = 250;
        int height = 120;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridheight = 3;
        gbc2.insets = new Insets(5, 5, 5, 5);
        p1.add(label, gbc2);   
        add(p);
        add(p1, BorderLayout.NORTH);
        setVisible(true);
        setSize(1100, 600);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            Level1Page level1 = new Level1Page();
            dispose(); 
        } else if (e.getSource() == exit) {

            dispose();
        }
    }

    public static void main(String[] args) {
      
        HomePage homePage = new HomePage();
    }
}