package week2;

public class ExContactCreation {
  public static void main(String[] args) {
//    Contact contact = new Contact("Artem","12381238", "12312312","test@gamail.com","sadovaya","kiev","klassnui","Ukraine");
    Contact contact = Contact.builder("Igor", "38093457891")
      .city("Kiev")
      .email("test@gmail.com")
      .street("Obolonskaya")
      .homePhoneNumber("044789461").build();
    System.out.println(contact);
  }
}
