import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("***********************************************************");
        System.out.println("Welcome to the Vending machine");
        System.out.println("***********************************************************");


        Scanner scanner = new Scanner(System.in);

        System.out.println("1.  For update list of products");
        System.out.println("2.  Display list of items");


        int menu = scanner.nextInt();
        switch (menu) {
            case 1: {
                System.out.println("You enter 1");

                MyJsonParser.updateList();
                break;
            }
            case 2: {
                System.out.println("You entered 2");

                MyJsonParser.showList();
                break;
            }
            default: {
                System.out.println("You entered a wrong data");
                break;
            }
        }

    }

}



