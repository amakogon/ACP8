package week4.alarma.message;

public class SMS implements IMessage {
  private final String data;

  public SMS(String data) {
    this.data = data;
  }

  @Override
  public String getInfo() {
    return data;
  }
}
