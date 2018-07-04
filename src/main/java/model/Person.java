package model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    private Long pesel;
    private String firstName;
    private String secondName;
    private String lastName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "personAddress")
    private Address address ;

    public Person() {
    }

    public Person(Long pesel,String firstName, String secondName, String lastName, Address address) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
