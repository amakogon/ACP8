package week4.alarma.subscriber;

import week4.alarma.message.IMessage;

public interface Subscriber {

  void update(IMessage message);
}
