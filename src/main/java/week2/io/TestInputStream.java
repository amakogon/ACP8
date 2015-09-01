package week2.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
  public static void main(String[] args) throws IOException {
    InputStream stream = new BufferedInputStream(new FileInputStream("/home/amakogon/myFile"));

    stream = new LowerCaseInputStream(stream);
    int res;
    StringBuilder builder = new StringBuilder();
    while ((res = stream.read()) != -1) {
      builder.append((char) res);
    }
    System.out.println(builder);

  }
}
