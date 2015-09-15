package week4.alarma.subscriber;

import week4.alarma.message.IMessage;

public class RegularSubscriber implements Subscriber {

  @Override
  public void update(IMessage message) {
    System.out.println("WE got message: " + message.getInfo());
  }
}
