package week8.day2;

public class Ex3 {
  public static void main(String[] args) {
    Company company = SpringContext.getContext().getBean(Company.class);
    System.out.println(company.getInfo());

    for (Employee employee : company.getEmployeeList()) {
      System.out.println(employee);
    }
  }
}
