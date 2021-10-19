package com.example.freemoneynoscam.services;

public class EmailValidator {
    // Method takes String and validates if it is correct email format.
    public boolean validate(String email) {

        boolean status = false;

        if (email.contains("@") && email.contains(".")) {
            status = true;
        }
        return status;

        // Should be done with Regex to properly check if it is email format.
        // This returns true on "@."

    }
}
