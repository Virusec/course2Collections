package pro.sky.course2collections.service;

import pro.sky.course2collections.data.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();

}
