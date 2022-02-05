package pro.sky.course2collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2collections.data.Employee;
import pro.sky.course2collections.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.add(firstName, lastName);
        return generateMessage(result, "успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return generateMessage(result, "удален");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeService.getAll();
    }

    private String generateMessage(Employee employee, String status) {

        return String.format("Сотрудник %s %s %s.", employee.getFirstName(), employee.getLastName(), status);
    }

}
