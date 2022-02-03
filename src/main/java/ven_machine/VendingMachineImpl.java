package ven_machine;

import calculator.CalculatorImpl;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter
@Getter
public class VendingMachineImpl implements VendingMachine {
    private Scanner scanner = new Scanner(System.in);
    private int amountChoseFromUser;
    private double moneyEnteredFromUser;
    private int idForSelectedProduct;
    private String priceForPars;
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
        logger.info("The item has been selected "+ MyJsonParser.itemList.get(idForSelectedProduct));
        return idForSelectedProduct;
    }


    @Override
    public int selectAmount() throws IOException, ParseException {
        logger.info("Provide user to select amount of item");
        do {
            System.out.println("Input amount, please!");
            this.amountChoseFromUser = scanner.nextInt();

        } while (!(amountChoseFromUser > 0 && amountChoseFromUser <= MyJsonParser.itemList.get(idForSelectedProduct).getAmount()));

       logger.info("Selected amount = "+amountChoseFromUser);
    return amountChoseFromUser;
    }

    @Override
    public void displayEnterDollarsMessage() {

        CalculatorImpl calculator = new CalculatorImpl();
        calculator.calculateTotalPrice();
       // System.out.println("You entered " + enterDollars() + " $!");
       // logger.info("display money");
    }

    @Override
    public double enterDollars() {
        System.out.println("Enter money");

        logger.info("Provide user to enter money");

        moneyEnteredFromUser = scanner.nextDouble();
        logger.info("The user inserted " + moneyEnteredFromUser + " $");
        return moneyEnteredFromUser;
    }

    @Override
    public double priceFromList() {
        double price = 0;
        try {
            this.priceForPars = String.valueOf(MyJsonParser.itemList.get(idForSelectedProduct));
            Pattern pattern = Pattern.compile("\\w+([0-9\\.][0-9]+)");
            Matcher matcher = pattern.matcher(priceForPars);

            for (int i = 0; i < matcher.groupCount(); i++) {
                matcher.find();
                price = Double.parseDouble(matcher.group());
                logger.info("The price for selected item is " + price+ " $");
            }
        } catch (IndexOutOfBoundsException e) {
            logger.info(e);
        }

        return price;
    }
    @Override
    public void update() {
        String name = MyJsonParser.itemList.get(idForSelectedProduct).getName();
        Integer amount = MyJsonParser.itemList.get(idForSelectedProduct).getAmount();
        String price = MyJsonParser.itemList.get(idForSelectedProduct).getPrice();
        Item item = new Item(name, amount, price);
        int idForUpdateAmountInJSonFile = MyJsonParser.itemList.get(idForSelectedProduct).getAmount() - amountChoseFromUser;
        MyJsonParser.updateList(item, idForUpdateAmountInJSonFile);
    }
}
