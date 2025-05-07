package com.botscrew.test.runner;

import com.botscrew.test.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class ConsoleRunner implements CommandLineRunner {

    private UniversityService service;

    @Override
    public void run(String... args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Enter command (or 'exit' to quit):");

        while (true) {
            String line = in.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            }

            try {
                if (line.toLowerCase().startsWith("who is head of department ")) {
                    String dept = line.substring(25).trim();
                    System.out.println(service.findDepartmentHead(dept));

                } else if (line.toLowerCase().startsWith("show ") && line.toLowerCase().endsWith(" statistics.")) {
                    String dept = line.substring(5, line.length() - 11).trim();
                    System.out.println(service.findDepartmentStats(dept));

                } else if (line.toLowerCase().startsWith("show the average salary for the department ")) {
                    String dept = line.substring(43, line.length() - 1).trim();
                    System.out.println(service.findAverageSalaryByDepartment(dept));

                } else if (line.toLowerCase().startsWith("show count of employee for ")) {
                    String dept = line.substring(26, line.length() - 1).trim();
                    System.out.println(service.findEmployeeCountByDepartment(dept));

                } else if (line.toLowerCase().startsWith("global search by ")) {
                    String name = line.substring(17, line.length() - 1).trim();
                    System.out.println(service.globalSearchByName(name));

                } else {
                    System.out.println("Unknown command.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        in.close();
    }

}
