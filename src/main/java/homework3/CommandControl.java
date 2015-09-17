package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Razer on 17.09.15.
 */
public class CommandControl {

    public ArrayList<ICommand> commands = new ArrayList<>();

    public static String localDirectory;

    public static String homeDirectory;

    public void setCommands(ICommand commands) {
        this.commands.add(commands);
    }

    public void readHomeDirectory() {
        String file=ClassLoader.getSystemResource("homeDirectory").getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currLine;
            while ((currLine = reader.readLine()) != null) {
                String[] pair = currLine.split("=");
                homeDirectory = pair[0].trim();
                CommandControl.localDirectory = homeDirectory;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CommandControl{" +
                "commands=" + commands +
                '}';
    }
}
