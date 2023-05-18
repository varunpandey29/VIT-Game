import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClickGame extends JFrame {
    private JButton startButton;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private JButton targetButton;
    private Timer gameTimer;
    private int score;
    private int timeLeft;

    public ClickGame() {
        setTitle("VIT Bhopal Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Background image
        ImageIcon backgroundImage = new ImageIcon("image\\gamebg.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1000, 500);
        panel.add(backgroundLabel);

        // Game content panel
        JPanel gamePanel = new JPanel();
        gamePanel.setOpaque(false);
        gamePanel.setLayout(new GridBagLayout());

        // Center panel for buttons and labels
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.BLUE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        centerPanel.add(scoreLabel);

        timeLabel = new JLabel("Time: 0");
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        centerPanel.add(timeLabel);

        targetButton = new JButton();
        targetButton.setPreferredSize(new Dimension(100, 50));
        targetButton.setBackground(Color.WHITE);
        targetButton.setForeground(Color.BLACK);
        targetButton.setFocusPainted(false);
        targetButton.setFont(new Font("Arial", Font.BOLD, 16));
        targetButton.setEnabled(false);
        centerPanel.add(targetButton);

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 50));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        centerPanel.add(startButton);

        // Add center panel to game panel with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gamePanel.add(centerPanel, gbc);

        panel.add(gamePanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void startGame() {
        score = 0;
        timeLeft = 10;
        updateScoreLabel();
        updateTimeLabel();

        startButton.setEnabled(false);
        targetButton.setEnabled(true);
        targetButton.setText("Click!");

        targetButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    score++;
                    updateScoreLabel();
                }
            }
        });

        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timeLeft--;
                updateTimeLabel();

                if (timeLeft == 0) {
                    endGame();
                }
            }
        }, 1000, 1000);
    }

    private void endGame() {
        gameTimer.cancel();
        startButton.setEnabled(true);
        targetButton.setEnabled(false);
        targetButton.setText("");

        JOptionPane.showMessageDialog(this, "Game Over!\nYour Score: " + score, "VIT Bhopal Game", JOptionPane.INFORMATION_MESSAGE);
        Home home = new Home();
        dispose();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    private void updateTimeLabel() {
        timeLabel.setText("Time: " + timeLeft + "s");
    }

    public static void main(String[] args) {
        new ClickGame();
    }
}
