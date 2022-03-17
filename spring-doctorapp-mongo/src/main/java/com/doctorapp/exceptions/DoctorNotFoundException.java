package com.doctorapp.exceptions;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException() {
        super();
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
