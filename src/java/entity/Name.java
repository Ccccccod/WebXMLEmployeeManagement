/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MR TU
 */
public class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.firstName.equals(name.getFirstName()) && this.lastName.equals(name.getLastName());
    }

    @Override
    public String toString() {
        return "Name{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
