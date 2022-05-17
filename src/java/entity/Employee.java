/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MR TU
 */
public class Employee {
    private String id;
    private Name name;
    private String gender;
    private String image;

    public Employee() {
    }

    public Employee(String id, Name name, String gender, String image) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.image = image;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public void setName(Name name) {
        this.name = name;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlElement
    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", image=" + image + '}';
    }
    
}
