package week2.drinks.GUI;
//http://www.java2s.com/Tutorial/Java/0240__Swing/0880__JTabbedPane.htm
//https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class GUI implements ActionListener{
    JButton printButton = new JButton("Print");
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.go();
    }

    public void go(){
        JFrame jFrame = new JFrame("Drinks");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);


        JTabbedPane jTabbedPane = new JTabbedPane();
        JPanel coffeePanel = new JPanel();
        JPanel teaPanel = new JPanel();
        coffeePanel.setName("Coffee");
        teaPanel.setName("Tea");
        jTabbedPane.addTab("Coffee", coffeePanel);
        jTabbedPane.addTab("Tea", teaPanel);
        printButton.addActionListener(this);
        jFrame.getContentPane().add(BorderLayout.CENTER, printButton);
        jFrame.getContentPane().add(BorderLayout.WEST, jTabbedPane);
        jFrame.setVisible(true);
        printButton.setSize(150, 150);
        printButton.setSize(150, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      printButton.setText("Hello!");
    }
}
