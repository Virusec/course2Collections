package pro.sky.course2collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeBookOverflowException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Array is overflow";

    public EmployeeBookOverflowException() {
        super(DEFAULT_MESSAGE);
    }


}
