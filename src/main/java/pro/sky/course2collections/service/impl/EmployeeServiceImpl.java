package pro.sky.course2collections.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.course2collections.data.Employee;
import pro.sky.course2collections.exception.EmployeeExistsException;
import pro.sky.course2collections.exception.EmployeeNotFoundException;
import pro.sky.course2collections.service.EmployeeService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (!employees.add(employee)) {
            throw new EmployeeExistsException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Set.copyOf(employees);
    }

}
