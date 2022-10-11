package at.ac.fhcampuswien;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number 1: ");
        double input = scanner.nextDouble();
        int counter = 2;
        double largest = 0;
        if (input > 0) {
            while (input > 0) {
                if (input > largest) {
                    largest = input;
                }
                System.out.print("Number "+ counter + ": ");
                input = scanner.nextDouble();
                counter++;
            }
            System.out.print("The largest number is ");
            System.out.printf("%.2f", largest);
            System.out.println();
        } else {
            System.out.println("No number entered.");
        }

    }

    //todo Task 2
    public void stairs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int input = scanner.nextInt();
        int counter = 1;

        if (input <= 0) {
            System.out.println("Invalid number!");
            return;
        }
        for (int rows = 1; rows <= input; rows++) {
            for (int column = 1; column <= rows; column++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid(){
        final int ROWS = 6;
        int spaces = ROWS - 1;
        int stars = 1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stars; k++) {
                System.out.print("*");
            }
            System.out.println();
            stars += 2;
            spaces--;
        }
    }

    //todo Task 4
    public void printRhombus(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int input = scanner.nextInt();
        System.out.print("c: ");
        char inputChar = scanner.next().charAt(0);
        int spaces = input / 2;
        String outputChar = "" + inputChar;
        if (input % 2 == 0) {
            System.out.println("Invalid number!");
            return;
        }
        for (int i = 0; i < input; i++) {
            if (i < input / 2) {
                printRhombusLines(spaces, outputChar);
                inputChar--;
                outputChar = inputChar + outputChar + inputChar;
                spaces--;
            } else {
                printRhombusLines(spaces, outputChar);
                if (outputChar.length() > 1)
                    outputChar = outputChar.substring(1,outputChar.length() - 1);
                spaces++;
            }
        }
    }

    private static void printRhombusLines(int spaces, String outputChar) {
        for (int j = 0; j < spaces; j++) {
            System.out.print(" ");
        }
        System.out.print(outputChar);
        System.out.println();
    }

    //todo Task 5
    public void marks(){
        int counter = 1;
        int negative = 0;
        double sum = 0.00;
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.print("Mark " + counter + ": ");
            input = scanner.nextInt();
            if (input > 5) {
                System.out.println("Invalid mark!");
            } else if (input >= 1){
                sum += input;
                counter++;
                if (input == 5)
                    negative++;
            }
        } while(input != 0);
        System.out.print("Average: " );
        if (counter > 1)
            sum = (sum / (counter - 1));
        System.out.printf("%.2f", sum);
        System.out.println();
        System.out.println("Negative marks: " + negative);
    }

    //todo Task 6
    public void happyNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int input = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();
        if (input > 1) {
            while(input != 1 && input != 4) {
                int num = input;
                while (num > 0) {
                    intList.add(num % 10);
                    num = num /10;
                }
                input = intList.stream().map(digit -> Math.pow(digit, 2))
                        .mapToInt(Double::intValue).sum();
                intList.clear();
            }
            if (input == 1) {
                System.out.println("Happy number!");
            }
            if(input == 4) {
                System.out.println("Sad number!");
            }
        }
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}