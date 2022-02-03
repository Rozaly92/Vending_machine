package ven_machine;

import item.Item;
import jSonParser.MyJsonParser;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import ven_machine.VendingMachine;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
@Setter
@Getter
public class VendingMachineImpl implements VendingMachine {
    private Scanner scanner = new Scanner(System.in);
    private int amountChoseFromUser;
    private double moneyEnteredFromUser;
    private int idForSelectedProduct;
    final static Logger logger = Logger.getLogger(VendingMachineImpl.class);

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public int selectProduct() throws IOException, ParseException {

        logger.info("Provide user to select an item");

        System.out.println("From 0 to 9");
        do {
            System.out.println("Select product, please!");
            this.idForSelectedProduct = scanner.nextInt();
            --idForSelectedProduct;

        } while (!(idForSelectedProduct >= 0 && idForSelectedProduct <= 8));

        return idForSelectedProduct;
    }


    @Override
    public int selectAmount() throws IOException, ParseException {
        logger.info("Provide user to select amount of item");
        do {
            System.out.println("Input amount, please!");
            this.amountChoseFromUser = scanner.nextInt();

        } while (!(amountChoseFromUser > 0 && amountChoseFromUser <= MyJsonParser.itemList.get(idForSelectedProduct).getAmount()));
        return amountChoseFromUser;
    }

    @Override
    public void displayEnterDollarsMessage() {

        System.out.println("You entered " + enterDollars() + " $!");
        logger.info("display money");
    }

    @Override
    public double enterDollars() {
        System.out.println("Enter money");

        logger.info("Provide user to enter money");

        moneyEnteredFromUser = scanner.nextDouble();
        return moneyEnteredFromUser;
    }
}
