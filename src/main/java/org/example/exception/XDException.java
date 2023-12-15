package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class XDException extends RuntimeException{
    private int code;
    private String msg;
}
