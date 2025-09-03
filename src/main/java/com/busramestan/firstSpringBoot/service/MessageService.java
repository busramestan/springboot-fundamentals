package com.busramestan.firstSpringBoot.service;

import com.busramestan.firstSpringBoot.controller.MessagePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessagePrinter messagePrinter;

    public void sendMessage() {
        messagePrinter.printMessage("message from MessageService");
    }

}
