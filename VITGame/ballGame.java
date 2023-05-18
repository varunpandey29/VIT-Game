import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ballGame extends JPanel implements KeyListener {
    private int ballX = 250;
    private int ballY = 250;
    private int ballSpeedY = 2;
    private int playerX = 225;
    private int playerY = 450;
    private int score = 0;
    private boolean isCollision = false;

    public ballGame() {
        setPreferredSize(new Dimension(1000, 500));
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 20, 20);

        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 50, 20);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("You have 5 lives" , 20, 30);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Missed: " + score, 30, 50);
    }

    public void moveBall() {
        if (isCollision) {
            ballY -= ballSpeedY;  

            if (ballY < 250) {
                isCollision = false; 
            }
        } else {
            ballY += ballSpeedY; 
        }

      
        if (ballY >= playerY && ballY <= playerY + 20 && ballX >= playerX && ballX <= playerX + 50) {
            isCollision = true; 
        }

       
        if (ballY >= getHeight()) {
            score++;
            ballX = (int) (Math.random() * (getWidth() - 20)); 
            ballY = 0;
            ballSpeedY = 2; 
            isCollision = false; 
        }

      
        if (score == 5) {
            JOptionPane.showMessageDialog(this, "GAME OVER!");
            System.exit(0);
        }

        repaint();
    }

    public void movePlayer(int dx) {
        playerX += dx;

   
        if (playerX < 0) {
            playerX = 0;
        } else if (playerX > getWidth() - 50) {
            playerX = getWidth() - 50;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            movePlayer(-5);
        } else if (key == KeyEvent.VK_RIGHT) {
            movePlayer(5);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Football Game");
        ballGame game = new ballGame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            game.moveBall();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}