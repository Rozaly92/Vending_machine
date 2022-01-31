import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayProductList() {
        try {
            List<Item> listForDisplay = MyJsonParser.listOfItems();
            int counterForDisplayNumber = 1;
            for (Item i : listForDisplay) {

                System.out.print(counterForDisplayNumber + " -> ");
                System.out.println(i);
                counterForDisplayNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int selectProduct() {
        System.out.println("Select product, please!");
        int idForSelectedProduct = scanner.nextInt();
        return idForSelectedProduct - 1; //idForSelectedProduct-1 because list starts from index 0
    }

    @Override
    public void displayEnterDollarsMessage() {
        System.out.println("You entered " + enterDollars() + " $!");
    }

    @Override
    public double enterDollars() {
        System.out.println("Enter money");
        double moneyEnteredFromUser = scanner.nextDouble();
        return moneyEnteredFromUser;
    }
}
