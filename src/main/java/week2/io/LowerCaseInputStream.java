package week2.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 *
 * */
public class LowerCaseInputStream extends FilterInputStream {

  public LowerCaseInputStream(InputStream in) {
    super(in);
  }

  @Override
  public int read() throws IOException {
    int res = super.read();
    return res == -1 ? -1 : Character.toLowerCase((char) res);
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    //TODO: implement this
    return super.read(b, off, len);
  }
}
