package week7.day1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSPORT")
public class Passport {
  @Id
  @GeneratedValue
  private int passport_id;
  private String serial;
  private String number;
  private String кимВиданый;

  public Passport() {
  }

  public Passport(String serial, String number) {
    this.serial = serial;
    this.number = number;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getКимВиданый() {
    return кимВиданый;
  }

  public void setКимВиданый(String кимВиданый) {
    this.кимВиданый = кимВиданый;
  }

  public int getPassport_id() {
    return passport_id;
  }

  public void setPassport_id(int passport_id) {
    this.passport_id = passport_id;
  }
}
