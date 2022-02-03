package calculator;

import helper.Helper;
import org.apache.log4j.Logger;

public class CalculatorImpl implements Calculator {
    private double moneyEnteredFromUser;
    private int id;
    private  int amountFromUser;
    private double price;
    private double pricePerTotalAmount;
    private double totalMoneyToChange;
    Helper helper = new Helper();
    final static Logger logger = Logger.getLogger(CalculatorImpl.class);

    @Override
    public double totalPricePerAmount() {
        id = helper.checkId();
        amountFromUser = helper.checkAmount();
        price = helper.priceFromList();
        moneyEnteredFromUser = helper.checkMoney();
        pricePerTotalAmount = price * amountFromUser;
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
            helper.update();

        } else {
            System.out.println("You don't enter enough money");

            logger.info("The user hasn't enough money");
            logger.info("The user was returned " + moneyEnteredFromUser + " $");

            System.out.println("Your money " + moneyEnteredFromUser + " $");
        }
    }

}
