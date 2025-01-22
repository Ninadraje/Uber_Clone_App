package com.personnal_project_uberApp.ride_service.utils;


import java.util.Random;

public class OtpUtils {


    public static int generateOtp() {

        Random random = new Random();
        return 1000 + random.nextInt(9000); // Generates a random number between 1000 and 9999
    }
}
