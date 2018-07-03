package entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
public class Customer extends User {
    private String id;

    public Customer() {
    }

    @Id
    @Override
    @Column(name = "ID", nullable = false)
    @GenericGenerator(name = "db-uuid", strategy = "guid")
    @GeneratedValue(generator = "db-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                "login='" + super.getLogin() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
