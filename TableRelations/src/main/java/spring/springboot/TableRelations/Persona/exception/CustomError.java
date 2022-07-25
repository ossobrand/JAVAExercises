package spring.springboot.TableRelations.Persona.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private String message;
    private int HttpCode;
}
