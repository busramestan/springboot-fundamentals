package com.busramestan.firstSpringBoot;

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
