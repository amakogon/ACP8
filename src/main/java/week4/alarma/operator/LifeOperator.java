package week4.alarma.operator;

import com.google.common.collect.Lists;
import week4.alarma.message.IMessage;
import week4.alarma.message.SMS;
import week4.alarma.subscriber.Subscriber;

import java.util.List;

public class LifeOperator implements IOperator {
  private List<Subscriber> subscribers;

  private IMessage message;

  public LifeOperator() {
    subscribers = Lists.newArrayList();
  }

  @Override
  public void notifySubscribers() {
    for (Subscriber subscriber : subscribers) {
      subscriber.update(message);
    }
  }

  @Override
  public void addSubscriber(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  @Override
  public void removeSubscriber(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }


  public void createMessage(String message) {
    this.message = new SMS(message);
  }
}
