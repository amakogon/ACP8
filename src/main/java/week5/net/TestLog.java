package week5.net;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLog {
  public static void main(String[] args) throws IOException {
    Logger logger = Logger.getLogger("MyLOG");
    FileHandler fileHandler = new FileHandler("/home/amakogon/logs", true);
    fileHandler.setFormatter(new SimpleFormatter());
    logger.addHandler(fileHandler);

    logger.log(Level.INFO, "my first log");
    logger.info("second message");


  }
}
