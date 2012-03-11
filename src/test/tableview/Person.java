/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tableview;

/**
 *
 * @author tomo
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
