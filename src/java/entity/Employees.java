/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MR TU
 */
@XmlRootElement
public class Employees {
    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlElement
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    
}
