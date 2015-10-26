package week8.day2.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Home on 13.10.2015.
 */
public class Company {
    //@Autowired
    //@Qualifier(value = "staff")
    private String address;
    private List<Employer> staff;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employer> getStaff() {
        return staff;
    }

    public void setStaff(List<Employer> staff) {
        this.staff = staff;
    }

    public String toString() {
        String info = "Address:" + address + "\n" + staff.toString();
        return info;
    }
}
