package com.company;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        boolean choiceBreak = false;
        boolean exitCondition = false;
        String inputChoiceTwo;


        while (!choiceBreak) {
            System.out.println("Hello, welcome to the password checker unit, please make a selection from the following\n1. Password comparison unit\n2. Password strength checker\n3. Password Funky-fier \n 4. Password storage");
            String inputChoice = in.nextLine();
            switch (inputChoice) {
                case "1" -> {
                    passwordChecker();
                }
                case "2" -> {
                    strengthChecker();
                }
                case "3" -> {
                    editPassword();
                }
                case "4" -> {
                    arrayList();
                }
                default -> System.out.print("please try again");
            }


            System.out.println("Enter 1 to repeat or 2 to exit");
            inputChoiceTwo = in.nextLine();
            while (!exitCondition) {
                switch (inputChoiceTwo) {
                    case "1" -> {
                        exitCondition = true;
                    }
                    case "2" -> {
                        exitCondition = true;
                        choiceBreak = true;
                    }
                    default -> System.out.print("Please try again");
                }
            }
        }
    }

            public static void passwordChecker () {

                System.out.println("Please enter an initial password");
                String originalPassword = in.nextLine();
                System.out.println("Please enter a comparison password");
                String inputPassword = in.nextLine();

                if (originalPassword.equals(inputPassword)) {
                    System.out.println("The password is the same");
                } else {
                    System.out.println("This password is incorrect, it should be: " + originalPassword + ", whilst you entered: " + inputPassword);
                }
            }

            public static void strengthChecker () {
                System.out.println("Please enter a password to check the strength of it: \n The strength can be improved by adding non standard characters and increasing the length ");
                String inputPassword = in.nextLine();
                char[] passwordArray = inputPassword.toCharArray();
                int strength = 0;

                for (char c : passwordArray) {
                    switch (c) {
                        case '!', '$', '"', '£', '%', '^', '&', '*', '(', ')' -> strength++;
                    }
                    if (inputPassword.length() >= 12) {
                        //TODO: add more / less strength depending on length
                        strength++;
                    }
                    System.out.print(c + " ");
                    System.out.print("The strength of this password is" + strength);
                }
            }

            public static void arrayList() {
                System.out.println("Please enter some passwords, pressing enter after each of them, then type exit when done");
                boolean passwordEntry = false;
                ArrayList<String> passwords = new ArrayList<String>();
                while (!passwordEntry) {

                    passwords.add(in.nextLine());

                    if (passwords.contains("exit")){
                        passwords.remove("exit");
                        passwordEntry = true;
                    }
                }
                System.out.println("These are the passwords you've entered");
                for (String s : passwords)
                    System.out.println(s);
            }


            public static void editPassword() {
                System.out.println("Please enter a password to funk it up: ");
                String password = in.nextLine();
                Random random = new Random();
                int number = random.nextInt(6);
                switch (number) {
                    case 1 -> password = password.toLowerCase();
                    case 2 -> password = password.toUpperCase();
                    case 3 -> password = password.concat("AAA");
                    case 4 -> password = password.replace('I', 'G');
                    case 5 -> password = password.replaceAll("a|e|i|o|u| |", "");
                }
                System.out.println("Your new, funky password: " + password);
            }
        }



