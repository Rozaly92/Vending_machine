import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        VendingMachine vendingMachine = new VendingMachineImpl();
        System.out.println("***********************************************************");
        System.out.println("Welcome to the Vending machine");
        System.out.println("***********************************************************");


        vendingMachine.displayProductList();
        Helper helper = new Helper();
        helper.showDetails();



    }

}



