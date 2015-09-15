package week4.alarma;

import week4.alarma.operator.LifeOperator;
import week4.alarma.subscriber.RegularSubscriber;

public class Main {
  public static void main(String[] args) {
    LifeOperator operator = new LifeOperator();
    RegularSubscriber subscriber1 = new RegularSubscriber();
    RegularSubscriber subscriber2 = new RegularSubscriber();
    operator.addSubscriber(subscriber1);
    operator.addSubscriber(subscriber2);

    operator.createMessage("Cheap phone calls! 100$ per month");
    operator.notifySubscribers();

    System.out.println("~~~after some time~~~~");
    operator.createMessage("500 sms free. Send 1 to 433 to subscribe");
    operator.removeSubscriber(subscriber2);
    operator.notifySubscribers();
  }
}
