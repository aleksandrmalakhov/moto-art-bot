package ru.malakhov.motoartbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
public class BotApp {

    public static void main(String[] args) {
        SpringApplication.run(BotApp.class, args);
    }
}