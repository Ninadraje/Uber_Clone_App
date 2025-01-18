package com.personnal_project_uberApp.driver_service.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * We can use this class as a template to hash the password
 * **/

public class PasswordUtils {


    // Hash a password for the first time
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Check that a plain text password matches a previously hashed one
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }


}
