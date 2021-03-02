package com.university.botscrew;

import com.university.botscrew.controller.InputOutputHandler;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private final InputOutputHandler inputOutputHandler;

    public void run() {
        System.out.println("Hi there!");
        while (true) {
            inputOutputHandler.menu();
            String inputLine = scanner.nextLine();
            inputOutputHandler.handle(inputLine);
        }
    }
}
