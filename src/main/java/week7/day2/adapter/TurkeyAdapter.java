package week7.day2.adapter;

public class TurkeyAdapter implements Duck {

  private final Turkey turkey;

  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public void quake() {
    turkey.gobble();
  }
}
