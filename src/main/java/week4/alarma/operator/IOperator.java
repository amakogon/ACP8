package week4.alarma.operator;

import week4.alarma.subscriber.Subscriber;

public interface IOperator {

  void notifySubscribers();

  void addSubscriber(Subscriber subscriber);

  void removeSubscriber(Subscriber subscriber);
}
