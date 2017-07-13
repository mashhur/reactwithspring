package org.reactjs.spring.api;

/**
 * Created by mashhur on 7/13/17.
 */
public class User {

    private String firstName;
    private String lastName;
    private String description;

    private User() {}

    public User(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}
