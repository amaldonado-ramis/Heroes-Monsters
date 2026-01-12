package es.ifoundthatx.cli;

import java.util.Scanner;

public class InputReader {
    private static final Scanner input = new Scanner(System.in);

    public static int readInt(int min, int max, String menu) {
        int option;

        while (true) {
            System.out.printf("%n%s $> ", menu);
            if (!input.hasNextInt()) { System.out.printf("%s $>", menu); input.nextLine(); }

            option = input.nextInt(); input.nextLine();
            if (option < min || option > max) { continue; }

            return option;
        }
    }

    public static String readLine() { return input.nextLine().trim(); }
}
