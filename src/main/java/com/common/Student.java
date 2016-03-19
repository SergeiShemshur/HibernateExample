package com.common;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private int age;
    @Column
    private Date birthdate;
    @Column
    private String surname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }
}
