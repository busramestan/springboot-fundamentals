package com.busramestan.firstSpringBoot.controller;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
