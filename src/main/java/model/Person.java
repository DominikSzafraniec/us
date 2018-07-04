package model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    private Long pesel;
    private String firstName;
    private String secoundName;
    private String lastname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "personAddress")
    private Address address ;

    public Person() {
    }

    public Person(Long pesel,String firstName, String secoundName, String lastname, Address address) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.secoundName = secoundName;
        this.lastname = lastname;
        this.address = address;
    }


    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecoundName() {
        return secoundName;
    }

    public void setSecoundName(String secoundName) {
        this.secoundName = secoundName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
