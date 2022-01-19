package com.batchbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchBotApplication {

    public static void main(String[] args) {

        System.exit(
                SpringApplication.exit(
                        SpringApplication.run(
                                BatchBotApplication.class, args)));
    }

}
