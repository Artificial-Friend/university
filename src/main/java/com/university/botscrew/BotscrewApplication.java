package com.university.botscrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotscrewApplication {
    private static Application application;

    public static void main(String[] args) {
        SpringApplication.run(BotscrewApplication.class, args);
        application.run();
    }

    @Autowired
    public void setApplication(Application application) {
        BotscrewApplication.application = application;
    }
}
