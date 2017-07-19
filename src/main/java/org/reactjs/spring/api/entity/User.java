package org.reactjs.spring.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Created by mashhur on 7/13/17.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User() {

    }

    public User(int id, String pwd, String firstName, String lastName, String mail) {
        this.user_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.password = pwd;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public void setPassword(String pwd){
        this.password = pwd;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, firstName='%s', lastName='%s', email='%s']", user_id,
                firstName, lastName, email);
    }
}
