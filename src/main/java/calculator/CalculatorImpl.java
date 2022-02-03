package calculator;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import ven_machine.VendingMachine;
import ven_machine.VendingMachineImpl;

import java.io.IOException;

public class CalculatorImpl implements Calculator {
    private double moneyEnteredFromUser;
    private int id;
    private  int amountFromUser;
    private double price;
    private double pricePerTotalAmount;
    private double totalMoneyToChange;
    VendingMachine vendingMachine = new VendingMachineImpl();
    final static Logger logger = Logger.getLogger(CalculatorImpl.class);

    @Override
    public double totalPricePerAmount() {
        try {
            id = vendingMachine.selectProduct();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            amountFromUser = vendingMachine.selectAmount();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        price = vendingMachine.priceFromList();
        moneyEnteredFromUser = vendingMachine.enterDollars();
        logger.info("price per one item = "+ price);
        pricePerTotalAmount = price * amountFromUser;
        logger.info("Total price for "+amountFromUser + " = " + pricePerTotalAmount);
        return pricePerTotalAmount;
    }



    @Override
    public void calculateTotalPrice() {
        totalMoneyToChange = totalPricePerAmount();

        if (moneyEnteredFromUser >= pricePerTotalAmount) {
            totalMoneyToChange = moneyEnteredFromUser - pricePerTotalAmount;

            logger.info("The calculation was successfully done");
            logger.info("Total price = " + totalMoneyToChange + " $");

            System.out.println("Your change is " + totalMoneyToChange + " $");
            vendingMachine.update();

        } else {
            System.out.println("You don't enter enough money");

            logger.info("The user hasn't enough money");
            logger.info("The user was returned " + moneyEnteredFromUser + " $");

            System.out.println("Your money " + moneyEnteredFromUser + " $");
        }
    }

}
