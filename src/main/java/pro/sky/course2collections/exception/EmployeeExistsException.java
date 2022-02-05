package pro.sky.course2collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistsException extends RuntimeException{

    public EmployeeExistsException() {
        super("Employee Book already contains this employee.");

    }
}
