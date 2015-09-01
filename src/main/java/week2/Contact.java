package week2;

public class Contact {
  private String name;
  private String phoneNumber;
  private String homePhoneNumber;
  private String email;
  private String street;
  private String city;
  private String region;
  private String country;

  private Contact(Builder builder) {
    this.name = builder.name;
    this.phoneNumber = builder.phoneNumber;
    this.homePhoneNumber = builder.homePhoneNumber;
    this.email = builder.email;
    this.street = builder.street;
    this.city = builder.city;
    this.region = builder.region;
    this.country = builder.country;
  }

  public static Builder builder(String name, String phoneNumber) {
    return new Builder(name, phoneNumber);
  }

  public static class Builder {
    private String name;
    private String phoneNumber;
    private String homePhoneNumber;
    private String email;
    private String street;
    private String city;
    private String region;
    private String country;

    private Builder(String name, String phoneNumber) {
      this.phoneNumber = phoneNumber;
      this.name = name;
    }

    public Builder homePhoneNumber(String homePhoneNumber) {
      this.homePhoneNumber = homePhoneNumber;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder street(String street) {
      this.street = street;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder region(String region) {
      this.region = region;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Contact build() {
      return new Contact(this);
    }
  }

  @Override
  public String toString() {
    return "Contact{" +
      "name='" + name + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", homePhoneNumber='" + homePhoneNumber + '\'' +
      ", email='" + email + '\'' +
      ", street='" + street + '\'' +
      ", city='" + city + '\'' +
      ", region='" + region + '\'' +
      ", country='" + country + '\'' +
      '}';
  }
}
