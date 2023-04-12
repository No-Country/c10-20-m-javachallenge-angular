package com.nocountryproject.Backend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException{

    public UserException(String msg) {
        super(msg);
    }
}
