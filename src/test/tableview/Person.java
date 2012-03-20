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
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
}
