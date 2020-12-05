package io.github.ricardormdev.springwebservice.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class IncompatibleLetterError extends RuntimeException {

    public IncompatibleLetterError(String number) {
        super("The number '" + number + "' has incompatible letters.");
    }

}
