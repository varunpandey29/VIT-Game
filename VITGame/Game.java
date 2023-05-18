import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {
    public Game() {
        setTitle("Game Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        ImageIcon button1Icon = new ImageIcon("image\\10secs.png");
        JButton button1 = new JButton(button1Icon);
        button1.setPreferredSize(new Dimension(250, 250));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFrame1();
            }
        });
        panel.add(button1, gbc);
        gbc.gridy++;
        JLabel label1 = new JLabel("Click Game");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label1, gbc);
        gbc.gridy++;
        ImageIcon button2Icon = new ImageIcon("image\\paddbleBall.jpeg");
        JButton button2 = new JButton(button2Icon);
        button2.setPreferredSize(new Dimension(250, 250));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFrame2();
            }
        });
        panel.add(button2, gbc);

        gbc.gridy++;
        JLabel label2 = new JLabel("Paddle Ball Game");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label2, gbc);
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Game Options");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openFrame1() {
        ClickGame cg = new ClickGame();
    }

    private void openFrame2() {
        JFrame frame = new JFrame("Paddle Ball Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballGame bg = new ballGame();
        frame.getContentPane().add(bg);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Thread gameThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    bg.moveBall();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        gameThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
}
