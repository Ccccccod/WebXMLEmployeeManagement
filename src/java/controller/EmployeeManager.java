/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import entity.Employees;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author MR TU
 */
public class EmployeeManager {

    private final File file;
    private final Unmarshaller unmarshaller;
    private final Marshaller marshaller;

    public EmployeeManager(String filePath) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        unmarshaller = context.createUnmarshaller();
        marshaller = context.createMarshaller();
        file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        if (file.createNewFile()) {
            marshaller.marshal(new Employees(new ArrayList<>()), file);
        }
    }

    private List<Employee> readFromXML() throws JAXBException {
        return Optional.ofNullable(((Employees) unmarshaller.unmarshal(file)).getEmployees()).orElse(new ArrayList<>());
    }

    private void writeToXML(List<Employee> employees) throws JAXBException {
        marshaller.marshal(new Employees(employees), file);
    }

    public boolean add(Employee employee) throws JAXBException {
        List<Employee> employees = readFromXML();
        boolean result = employees.add(employee);
        writeToXML(employees);
        return result;
    }

    public boolean update(Employee employee) throws JAXBException {
        List<Employee> employees = readFromXML();
        boolean result = employees.stream().anyMatch(s -> s.getId().equals(employee.getId()));
        employees = employees.stream()
                .map(s -> s.getId().equals(employee.getId()) ? employee : s)
                .collect(Collectors.toList());
        writeToXML(employees);
        return result;
    }

    public boolean delete(String id) throws JAXBException {
        List<Employee> employees = readFromXML();
        boolean result = employees.removeIf(e -> e.getId().equals(id));
        writeToXML(employees);
        return result;
    }

    public List<Employee> list() throws JAXBException {
        List<Employee> employees = readFromXML();
        return employees;
    }

    public List<Employee> search(Employee employee) throws JAXBException {
        List<Employee> employees = readFromXML();
        return employees.stream()
                .filter(e -> e.getId().contains(employee.getId()))
                .filter(e -> e.getName().getFirstName().contains(employee.getName().getFirstName()))
                .filter(e -> e.getName().getLastName().contains(employee.getName().getLastName()))
                .filter(e -> e.getGender().equals(employee.getGender()))
                .collect(Collectors.toList());
    }
}
