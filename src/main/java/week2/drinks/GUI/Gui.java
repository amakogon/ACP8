package week2.drinks.GUI;

import week2.drinks.core.Drink;
import week2.drinks.core.DrinkFactory;
import week2.drinks.core.ToppingFactory;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class Gui {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.go();
    }

    public void go() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception system) {
            system.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TabbedPane();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class TabbedPane {
        public TabbedPane() throws IOException {

            JFrame frame = new JFrame("DRINKS CASHIER");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(350, 380));
            frame.setResizable(false);
            frame.setLayout(new BorderLayout());

            //MAIN PAN
            JPanel mainPanel = new JPanel();
            mainPanel.setBorder(BorderFactory.createBevelBorder(1));
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            mainPanel.setLayout(new BorderLayout());

            //TABS
            JTabbedPane tabbedPane = new JTabbedPane();

            JPanel coffePanel = new JPanel();
            coffePanel.setName("coffee");
            BufferedImage coffeePicture = ImageIO.read(ClassLoader.getSystemResource("coffeePicture.png"));
            Image coffeePictureScaledInstance = coffeePicture.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel coffeeLabel = new JLabel(new ImageIcon(coffeePictureScaledInstance));
            coffePanel.add(coffeeLabel, BorderLayout.CENTER);

            JPanel teaPanel = new JPanel();
            teaPanel.setName("tea");
            BufferedImage teaPicture = ImageIO.read(ClassLoader.getSystemResource("teaPicture.png"));
            Image teaPictureScaledInstance = teaPicture.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel teaLabel = new JLabel(new ImageIcon(teaPictureScaledInstance));
            teaPanel.add(teaLabel, BorderLayout.CENTER);


            tabbedPane.add("Coffee", coffePanel);
            tabbedPane.add("Tea", teaPanel);
            mainPanel.add(tabbedPane, BorderLayout.NORTH);


            JPanel toppingsPanel = new JPanel();
            toppingsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            String[] toppings = {"Milk", "Cinnamon", "Cardamon", "Clove", "Anise", "Mint"};


            toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.PAGE_AXIS));
            JLabel toppingsLabel = new JLabel("Toppings:");
            toppingsPanel.add(toppingsLabel, BorderLayout.NORTH);
            toppingsLabel.setBorder(BorderFactory.createRaisedBevelBorder());
            for (String name : toppings) {
                toppingsPanel.add(newJcheckbox(name));
            }

            JTextArea orderText = new JTextArea();
            orderText.setLineWrap(true);

            ActionListener orderListener = new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    Drink mainDrink = new DrinkFactory().getDrink(tabbedPane.getSelectedComponent().getName().toLowerCase());
                    Component[] toppingsPaneList = toppingsPanel.getComponents();
                    ArrayList<JCheckBox> toppingsList = new ArrayList<>();
                    for (Component c : toppingsPaneList) {
                        if (c instanceof JCheckBox) {
                            toppingsList.add((JCheckBox) c);
                        }
                    }
                    ArrayList<JCheckBox> selectedToppingsList = new ArrayList<>();
                    for (JCheckBox c : toppingsList) {
                        if (c.isSelected()) selectedToppingsList.add(c);

                    }
                    Drink readyDrink = mainDrink;
                    for (JCheckBox c : selectedToppingsList) {
                        readyDrink = new ToppingFactory().getDrink(c.getName().toLowerCase(), readyDrink);

                    }

                    orderText.setText("Your order: \n" + readyDrink.getDescription() + ". \nPrice is " + readyDrink.price() + " UAH.");
                    orderText.repaint();


                }
            };

            //BUTTON
            JButton orderButton = new JButton("Order");
            orderButton.addActionListener(orderListener);

            //ADD TO FRAME
            frame.add(orderButton, BorderLayout.SOUTH);
            mainPanel.add(orderText);


            frame.add(mainPanel, BorderLayout.CENTER);
            frame.add(toppingsPanel, BorderLayout.EAST);


            frame.setVisible(true);
        }

        private JCheckBox newJcheckbox(String name) {
            JCheckBox checkBox = new JCheckBox(name);
            checkBox.setName(name);
            return checkBox;
        }
    }
}

