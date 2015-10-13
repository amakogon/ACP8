package week8.di;

import java.util.Set;

public class Box {

  private Set<Ball> balls;

  public Set<Ball> getBalls() {
    return balls;
  }

  public void setBalls(Set<Ball> balls) {
    this.balls = balls;
  }

  public static class Ball{
    private String color;

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public String toString() {
      return color;
    }
  }
}
