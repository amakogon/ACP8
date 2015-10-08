package week7.day1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Arrays;
import java.util.Date;

public class Ex1 {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().configure();
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    Session session = sessionFactory.openSession();
/*    Transaction transaction = session.getTransaction();
    transaction.begin();*/
    Student student = new Student();
    student.setName("Albert");
    student.setEntryDate(new Date());
    student.setEmail(new Email("test@gmail.com"));
    Passport passport = new Passport("QR", "31231");
    student.setPassport(passport);
    student.setSubjects(Arrays.asList("Math", "Biology", "Sport"));

    session.beginTransaction();
//    student.setName("Tester");
    session.save(passport);
    session.save(student);
    session.getTransaction().commit();
    session.close();

/*    student = null;

    session = sessionFactory.openSession();
    session.beginTransaction();
    student = (Student) session.get(Student.class, 2);
    session.getTransaction().commit();
    session.close();
    System.out.println(student);*/

  }
}
