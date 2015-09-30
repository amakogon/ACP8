package homework3.command;

import homework3.ICommand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Razer on 24.09.15.
 */
public class CatCommand implements ICommand {
    private String name;

    public CatCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(String param) {
        try {
            BufferedReader reader=new BufferedReader(new FileReader(param) {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
