import helper.Helper;
import org.json.simple.parser.ParseException;
import ven_machine.VendingMachine;
import ven_machine.VendingMachineImpl;

import java.io.IOException;

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



