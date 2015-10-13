package week8.day2;

import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Company {
  private String name;
  private List<Employee> employeeList;
  private Address address;

  @Autowired(required = false)
  private PhoneNumber phoneNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  public Address getAddress() {
    return address;
  }

  @Autowired
  public void setAddress(Address address) {
    this.address = address;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getInfo() {
    return MoreObjects.toStringHelper(this)
      .add("name", name)
      .add("Address", address)
      .add("phone", phoneNumber)
      .omitNullValues()
      .toString();
//    return String.format("Name=%s. Address=%s, phone=%s",name, address, optional.orElseGet(() -> emptyPN));
  }
}
