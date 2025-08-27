package com.busramestan.firstSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
