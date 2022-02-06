import ven_machine.VendingMachine;
import ven_machine.VendingMachineImpl;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachineImpl();
        System.out.println("***********************************************************");
        System.out.println("Welcome to the Vending machine");
        System.out.println("***********************************************************");



        vendingMachine.displayProductList();
        vendingMachine.displayEnterDollarsMessage();


        System.out.println("***********************************************************");
        System.out.println("");
        System.out.println("***********************************************************");
    }

}



