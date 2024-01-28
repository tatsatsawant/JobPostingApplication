package dev.tatsat.JobPostingApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private Date timestamp;
    private int statusCode;
    private String message;
    private String description;
}