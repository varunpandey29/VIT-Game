import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImmersionProgram extends JFrame implements ActionListener {
    private int redButtonClickCount;
    private int greenButtonClickCount;
    private JButton backButton;

    public ImmersionProgram() {
        redButtonClickCount = 0;
        greenButtonClickCount = 0;

        setTitle("Immersion 2024");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1500, 600));

        setContentPane(new JLabel(new ImageIcon("image\\flion.png")));
        setLayout(new BorderLayout());

        JPanel headlinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel headlineLabel = new JLabel("Immersion 2024");
        headlineLabel.setFont(new Font("SERIF", Font.BOLD, 30));
        headlinePanel.add(headlineLabel);

        JPanel subheadlinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel subheadlineLabel = new JLabel("Lions of VIT Bhopal");
        subheadlineLabel.setFont(new Font("SERIF", Font.BOLD, 35));
        subheadlinePanel.add(subheadlineLabel);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("To get selected in Immersion, you have to follow some do's and don'ts, consider Green -> Do's and Red -> Don'ts");
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 18));
        titlePanel.add(titleLabel);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButtonsToPanel(redPanel, "image\\finstagram.png", "image\\fvg.png", "image\\fyt.png");

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButtonsToPanel(greenPanel, "image\\fdsa.jpg", "image\\fcn.jpg", "image\\os.jpg");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false); 
        mainPanel.add(headlinePanel, BorderLayout.NORTH);
        mainPanel.add(subheadlinePanel, BorderLayout.CENTER);
        mainPanel.add(titlePanel, BorderLayout.SOUTH);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButtonPanel.add(backButton);

        add(mainPanel, BorderLayout.NORTH);
        add(redPanel, BorderLayout.WEST);
        add(greenPanel, BorderLayout.EAST);
        add(backButtonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtonsToPanel(JPanel panel, String... buttonIcons) {
        for (String icon : buttonIcons) {
            JButton button = new JButton(new ImageIcon(icon));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (panel.getBackground().equals(Color.RED) && redButtonClickCount < 3) {
                        panel.remove(button);
                        redButtonClickCount++;
                    } else if (panel.getBackground().equals(Color.GREEN) && greenButtonClickCount < 3) {
                        panel.remove(button);
                        greenButtonClickCount++;
                    }
                    panel.revalidate();
                    panel.repaint();

                    if (redButtonClickCount + greenButtonClickCount == 6) {
                        showCongratulationsDialog();
                    }
                }
            });
            panel.add(button);
        }
    }

    private void showCongratulationsDialog() {
        JOptionPane.showMessageDialog(this, "Congratulations! You are selected in the Immersion Program!");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            Home home = new Home(); 
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImmersionProgram();
            }
        });
    }
}
