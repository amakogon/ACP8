package week8.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle {
  @Autowired(required = false)
  @Qualifier(value = "pointA")
  private Point center;
  private int radius;

  public Point getCenter() {
    return center;
  }

  public void setCenter(Point center) {
    this.center = center;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  @Override
  public String toString() {
    return "Circle{" +
      "center=" + center +
      ", radius=" + radius +
      '}';
  }
}
