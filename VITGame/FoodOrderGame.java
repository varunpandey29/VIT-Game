import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FoodOrderGame extends JFrame {

    private JLabel label, label1;
    private JButton pizzaButton;
    private JButton burgerButton;
    private JButton friesButton;
    private JButton coffeeButton;
    private JPanel ordersPanel;
    private Map<String, Integer> orderCounts;

    public FoodOrderGame() {
        setTitle("Under Belly");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label = new JLabel("Hungry? Let's beat your Cravings at");
        label.setFont(new Font("SERIF", Font.BOLD, 14));

        label1 = new JLabel("VIT Bhopal's Cafeteria - UNDER BELLY");
        label1.setFont(new Font("SERIF", Font.BOLD, 20));

        labelPanel.add(label);
        labelPanel.add(label1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 50, 50));

        pizzaButton = createButton("Fries", "image\\fries.jpg", 200, 150);
        pizzaButton.setBackground(Color.LIGHT_GRAY);
        burgerButton = createButton("Burger", "image\\Burger.jpg", 200, 150);
        burgerButton.setBackground(Color.LIGHT_GRAY);
        friesButton = createButton("Pizza", "image\\pizza.jpg", 200, 150);
        friesButton.setBackground(Color.LIGHT_GRAY);
        coffeeButton = createButton("Coffee", "image\\ColdCoffee.jpg", 200, 150);
        coffeeButton.setBackground(Color.LIGHT_GRAY);

        buttonPanel.add(pizzaButton);
        buttonPanel.add(burgerButton);
        buttonPanel.add(friesButton);
        buttonPanel.add(coffeeButton);

        orderCounts = new HashMap<>();
        ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        ordersPanel.setBackground(new Color(255, 218, 185));

        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(new JLabel("  Your Orders  "), BorderLayout.NORTH);
        eastPanel.add(ordersPanel, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Checkout");
        JButton backButton = new JButton("Back");
        JPanel buttonPanelBottom = new JPanel();
        buttonPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanelBottom.add(backButton);
        buttonPanelBottom.add(checkoutButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanelBottom, BorderLayout.SOUTH);

        add(mainPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    Home home = new Home();
                    dispose();
                }
                orderCounts.clear();
                updateOrdersPanel();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == checkoutButton) {
                    showOrder();
                    Home home = new Home();
                    dispose();
                }
            }
        });
    }

    private JButton createButton(String label, String imagePath, int width, int height) {
        JButton button = new JButton(label);
        button.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel textLabel = new JLabel(label, SwingConstants.CENTER);
        textLabel.setFont(new Font("SERIF", Font.BOLD, 16));

        button.add(imageLabel, BorderLayout.CENTER);
        button.add(textLabel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementOrderCount(label);
                switch (label) {
                    case "Pizza":
                        JOptionPane.showMessageDialog(FoodOrderGame.this, "Pizza added to the order.");
                        break;
                    case "Burger":
                        JOptionPane.showMessageDialog(FoodOrderGame.this, "Burger added to the order.");
                        break;
                    case "Fries":
                        JOptionPane.showMessageDialog(FoodOrderGame.this, "Fries added to the order.");
                        break;
                    case "Coffee":
                        JOptionPane.showMessageDialog(FoodOrderGame.this, "Coffee added to the order.");
                        break;
                }
            }
        });

        return button;
    }

    private void incrementOrderCount(String item) {
        if (orderCounts.containsKey(item)) {
            int count = orderCounts.get(item);
            orderCounts.put(item, count + 1);
        } else {
            orderCounts.put(item, 1);
        }
        updateOrdersPanel();
    }

    private void updateOrdersPanel() {
        ordersPanel.removeAll();
        for (Map.Entry<String, Integer> entry : orderCounts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            JLabel orderLabel = new JLabel(item + ": " + count);
            ordersPanel.add(orderLabel);
        }
        ordersPanel.revalidate();
        ordersPanel.repaint();
    }

    private void showOrder() {
        StringBuilder message = new StringBuilder("Order Summary:\n");
        if (orderCounts.isEmpty()) {
            message.append("No items selected.");
        } else {
            for (Map.Entry<String, Integer> entry : orderCounts.entrySet()) {
                String item = entry.getKey();
                int count = entry.getValue();
                message.append(item).append(": ").append(count).append("\n");
            }
        }
        JOptionPane.showMessageDialog(FoodOrderGame.this, message.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FoodOrderGame().setVisible(true);
            }
        });
    }
}
