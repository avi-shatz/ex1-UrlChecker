package prog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = null;
        String[] inputArgs = null;

        System.out.println("Please enter a command!");

        try {
            scanner = new Scanner(System.in);
            inputArgs = scanner.nextLine().split(" ");

            System.out.println("The arguments you have entered: ");
            for (String s : inputArgs) {
                System.out.println(s);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
