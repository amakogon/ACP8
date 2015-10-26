package week8.day2.company;

import week8.day2.SpringContext;

/**
 * Created by Home on 13.10.2015.
 */
public class CompMain {
    public static void main(String[] args) {

        Company maxIndustry = SpringContext.getContext().getBean("company", Company.class);
        System.out.println(maxIndustry.toString());
    }
}
