package com.university.botscrew.controller;

import com.university.botscrew.service.DepartmentService;
import com.university.botscrew.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InputOutputHandler {
    public static final String MENU_MESSAGE = "\nAvailable commands:\n"
            + "1. 'Who is head of department {department_name}'\n"
            + "2. 'Show {department_name} statistics'\n"
            + "3. 'Show the average salary for the department {department_name}'\n"
            + "4. 'Show count of employee for {department_name}'\n"
            + "5. 'Global search by {any_text}'\n"
            + "6. 'Exit'\n";
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public void menu() {
        System.out.println(MENU_MESSAGE);
        System.out.print("Enter your command: ");
    }

    public void handle(String input) {
        input = input.toLowerCase();
        try {
            if (input.contains("who is head of department ")) {
                System.out.println(departmentService.getDepartmentHead(input.substring(26)));
                return;
            }
            if (input.contains("show ") && input.contains(" statistics")) {
                System.out.println(departmentService
                        .getDepartmentStatistic(input.substring(5, input.length() - 11)));
                return;
            }
            if (input.contains("show the average salary for the department ")) {
                System.out.println(departmentService
                        .getAverageDepartmentSalary(input.substring(43)));
                return;
            }
            if (input.contains("show count of employee for ")) {
                System.out.println(departmentService
                        .getDepartmentEmployeeCount(input.substring(27)));
                return;
            }
            if (input.contains("global search by ")) {
                employeeService.findAny(input.substring(17)).forEach(employee ->
                        System.out.println(employee.getName()));
                return;
            }
            if (input.equals("exit")) {
                System.exit(0);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("\033[33mWrong input, please try again\033[0m");
        }
    }
}
