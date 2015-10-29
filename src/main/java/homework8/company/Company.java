package homework8.company;

import java.util.List;

/**
 * Created by Razer on 13.10.15.
 */
public class Company {
    private List<Employee> employeers;
    private String address;
    private int phoneNumber;

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addEmploers(Employee employee) {
        employeers.add(employee);
    }

    public List<Employee> getEmployeers() {
        return employeers;
    }

    public void setEmployeers(List<Employee> employeers) {
        this.employeers = employeers;
    }

    @Override
    public String toString() {
        return "Company{" +
                "address='" + address + '\'' +
                ", employeers=" + employeers +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
