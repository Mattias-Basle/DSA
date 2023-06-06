package designPatterns.TemplatePattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TeaWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Steeping the tea...");
    }

    public void addCondiments() {
        System.out.println("Adding lemon.");
    }

    public boolean customerWantsCondiments() {
        String answer = getUserInput();

        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        System.out.println("Would you like milk and sugar with your coffee (y/n)? ");

        Scanner input = new Scanner(System.in);
        String answer = input.next();

        return answer;
    }
}
