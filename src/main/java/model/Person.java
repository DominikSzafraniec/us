package model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long pesel;
    private String firstName;
    private String secoundName;
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "personAddress")
    private Address address ;

    public Person() {
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
