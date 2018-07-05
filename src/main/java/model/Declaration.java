package model;

import javax.persistence.*;

@Entity
public class Declaration {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Integer rok;

    @OneToOne
    Person person;
    Double r1c1;
    Double r1c2;
    Double r1c3;
    Double r1c4;
    Double r1c5;
    Double r2c1;
    Double r2c2;
    Double r2c3;
    Double r2c4;
    Double r2c5;
    Double r3c1;
    Double r3c2;
    Double r3c3;
    Double r3c4;
    Double r3c5;
    Double r4c1;
    Double r4c2;
    Double r4c3;
    Double r4c4;
    Double r4c5;
    Double r5c1;
    Double r5c2;
    Double r5c3;
    Double r5c4;
    Double r5c5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getR1c1() {
        return r1c1;
    }

    public void setR1c1(Double r1c1) {
        this.r1c1 = r1c1;
    }

    public Double getR1c2() {
        return r1c2;
    }

    public void setR1c2(Double r1c2) {
        this.r1c2 = r1c2;
    }

    public Double getR1c3() {
        return r1c3;
    }

    public void setR1c3(Double r1c3) {
        this.r1c3 = r1c3;
    }

    public Double getR1c4() {
        return r1c4;
    }

    public void setR1c4(Double r1c4) {
        this.r1c4 = r1c4;
    }

    public Double getR1c5() {
        return r1c5;
    }

    public void setR1c5(Double r1c5) {
        this.r1c5 = r1c5;
    }

    public Double getR2c1() {
        return r2c1;
    }

    public void setR2c1(Double r2c1) {
        this.r2c1 = r2c1;
    }

    public Double getR2c2() {
        return r2c2;
    }

    public void setR2c2(Double r2c2) {
        this.r2c2 = r2c2;
    }

    public Double getR2c3() {
        return r2c3;
    }

    public void setR2c3(Double r2c3) {
        this.r2c3 = r2c3;
    }

    public Double getR2c4() {
        return r2c4;
    }

    public void setR2c4(Double r2c4) {
        this.r2c4 = r2c4;
    }

    public Double getR2c5() {
        return r2c5;
    }

    public void setR2c5(Double r2c5) {
        this.r2c5 = r2c5;
    }

    public Double getR3c1() {
        return r3c1;
    }

    public void setR3c1(Double r3c1) {
        this.r3c1 = r3c1;
    }

    public Double getR3c2() {
        return r3c2;
    }

    public void setR3c2(Double r3c2) {
        this.r3c2 = r3c2;
    }

    public Double getR3c3() {
        return r3c3;
    }

    public void setR3c3(Double r3c3) {
        this.r3c3 = r3c3;
    }

    public Double getR3c4() {
        return r3c4;
    }

    public void setR3c4(Double r3c4) {
        this.r3c4 = r3c4;
    }

    public Double getR3c5() {
        return r3c5;
    }

    public void setR3c5(Double r3c5) {
        this.r3c5 = r3c5;
    }

    public Double getR4c1() {
        return r4c1;
    }

    public void setR4c1(Double r4c1) {
        this.r4c1 = r4c1;
    }

    public Double getR4c2() {
        return r4c2;
    }

    public void setR4c2(Double r4c2) {
        this.r4c2 = r4c2;
    }

    public Double getR4c3() {
        return r4c3;
    }

    public void setR4c3(Double r4c3) {
        this.r4c3 = r4c3;
    }

    public Double getR4c4() {
        return r4c4;
    }

    public void setR4c4(Double r4c4) {
        this.r4c4 = r4c4;
    }

    public Double getR4c5() {
        return r4c5;
    }

    public void setR4c5(Double r4c5) {
        this.r4c5 = r4c5;
    }

    public Double getR5c1() {
        return r5c1;
    }

    public void setR5c1(Double r5c1) {
        this.r5c1 = r5c1;
    }

    public Double getR5c2() {
        return r5c2;
    }

    public void setR5c2(Double r5c2) {
        this.r5c2 = r5c2;
    }

    public Double getR5c3() {
        return r5c3;
    }

    public void setR5c3(Double r5c3) {
        this.r5c3 = r5c3;
    }

    public Double getR5c4() {
        return r5c4;
    }

    public void setR5c4(Double r5c4) {
        this.r5c4 = r5c4;
    }

    public Double getR5c5() {
        return r5c5;
    }

    public void setR5c5(Double r5c5) {
        this.r5c5 = r5c5;
    }
}
