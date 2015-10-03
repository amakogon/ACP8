package homework.homework5.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created by Home on 03.10.2015.
 */
public class ChatClient {
    private JTextArea inputMessagesArea;
    private JTextArea outputMessagesArea;
    private JButton sendButton;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatClient() {
        setupGUI();
    }

    private void setupGUI() {
        JFrame frame = new JFrame("Chat client");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (screenSize.width < frameSize.width) {
            frameSize = screenSize;
        }
        if (screenSize.height < frameSize.height) {
            frameSize = screenSize;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);

        setConnection();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        inputMessagesArea = new JTextArea();
        inputMessagesArea.setEditable(false);
        inputMessagesArea.setLineWrap(true);
        inputMessagesArea.setBackground(Color.cyan);
        inputMessagesArea.setColumns(38);
        inputMessagesArea.setRows(30);
        Font font = new Font("Courier New", Font.BOLD, 16);
        inputMessagesArea.setFont(font);


        outputMessagesArea = new JTextArea();
        JScrollPane scroller = new JScrollPane(inputMessagesArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        sendButton = new JButton("Send");
        sendButton.addActionListener(new ListenerForSendButton());
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.X_AXIS));
        outputPanel.add(outputMessagesArea);
        outputPanel.add(sendButton);

        mainPanel.add(scroller);
        mainPanel.add(outputPanel);


        frame.getContentPane().add(mainPanel);

        Thread readThread = new Thread(new ReaderFromServer());
        readThread.start();


        frame.setVisible(true);

    }

    private void setConnection() {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ListenerForSendButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = outputMessagesArea.getText();
            writer.println(message);
            writer.flush();
            outputMessagesArea.setText("");
        }
    }

    private class ReaderFromServer implements Runnable {

        @Override
        public void run() {
            String message;
            while (true) {
                try {
                    if ((message = reader.readLine()) != null) {
                        inputMessagesArea.append("\n" + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
