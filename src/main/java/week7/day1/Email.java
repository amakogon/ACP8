package week7.day1;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
  private String value;

  public Email() {
  }

  public Email(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
