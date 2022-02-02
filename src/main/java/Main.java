import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        VendingMachine vendingMachine = new VendingMachineImpl();
        System.out.println("***********************************************************");
        System.out.println("Welcome to the Vending machine");
        System.out.println("***********************************************************");


        Scanner scanner = new Scanner(System.in);

        System.out.println("1.  Update list of products");
       // System.out.println("2.  Display list of items");
        System.out.println("3.  Chose product");
        System.out.println("4.  Enter money");


        int menu = scanner.nextInt();
        switch (menu) {
            case 1: {
                System.out.println("You entered 1");
               // MyJsonParser.updateList();
                break;
            }
            case 2: {
                System.out.println("You entered 2");
                vendingMachine.displayProductList();

            }
            case 3: {
                System.out.println("You entered 3");
                // vendingMachine.selectProduct();
                vendingMachine.displayProductList();
                Helper helper = new Helper();
                helper.showDetails();
                // Calculator calculator = new CalculatorImpl() ;
                //calculator.calculateSumForChange();
                break;
            }
            case 4: {
                System.out.println("You entered 4");
//                Calculator calculator = new CalculatorImpl() ;
//                calculator.calculateSumForChange();
                vendingMachine.displayEnterDollarsMessage();
                break;
            }
            default: {
                System.out.println("You entered a wrong data");
                break;
            }
        }

    }

}



