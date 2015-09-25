package week2.drinks.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

    public void go(){
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
                    TabbedPane tP = new TabbedPane();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class TabbedPane{
        public TabbedPane() throws IOException {
            //Dimension dimension = Toolkit.getDefaultToolkit().getSc;
            JFrame frame = new JFrame("DRINKS CASHIER");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(300,300));
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
            BufferedImage coffeePicture = ImageIO.read(ClassLoader.getSystemResource("coffeePicture.png"));
            Image coffeePictureScaledInstance = coffeePicture.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel coffeeLabel = new JLabel(new ImageIcon(coffeePictureScaledInstance));
            coffePanel.add(coffeeLabel,BorderLayout.CENTER);

            JPanel teaPanel = new JPanel();
            BufferedImage teaPicture = ImageIO.read(ClassLoader.getSystemResource("teaPicture.png"));
            Image teaPictureScaledInstance = teaPicture.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel teaLabel = new JLabel(new ImageIcon(teaPictureScaledInstance));
            teaPanel.add(teaLabel,BorderLayout.CENTER);



            tabbedPane.add("Coffee",coffePanel);
            tabbedPane.add("Tea",teaPanel);
            mainPanel.add(tabbedPane, BorderLayout.NORTH);

            //BUTTON
            JButton orgerButton = new JButton("Order");


            JPanel toppingsPanel = new JPanel();
            toppingsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            JCheckBox milkCheckBox = new JCheckBox("Milk");
            JCheckBox cinnamonCheckBox = new JCheckBox("Cinnamon");
            JCheckBox cardamomCheckBox = new JCheckBox("Cardamom");
            JCheckBox cloveCheckBox = new JCheckBox("Clove");
            JCheckBox aniseCheckBox = new JCheckBox("Anise");
            JCheckBox mintCheckBox = new JCheckBox("Mint");


            toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.PAGE_AXIS));
            JLabel toppingsLabel = new JLabel("Toppings:");
            toppingsLabel.setBorder(BorderFactory.createRaisedBevelBorder());
            toppingsPanel.add(toppingsLabel);
            toppingsPanel.add(milkCheckBox);
            toppingsPanel.add(cinnamonCheckBox);
            toppingsPanel.add(cardamomCheckBox);
            toppingsPanel.add(cloveCheckBox);
            toppingsPanel.add(aniseCheckBox);
            toppingsPanel.add(mintCheckBox);


            //ADD TO FRAME
            frame.add(orgerButton, BorderLayout.SOUTH);
            frame.add(mainPanel, BorderLayout.CENTER);
            frame.add(toppingsPanel, BorderLayout.EAST);



            frame.setVisible(true);
        }
    }
}

