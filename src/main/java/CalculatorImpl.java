import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CalculatorImpl implements Calculator {
    private double moneyEnteredFromUser;
    int id;
    int amountFromUser;
    double price;
    double pricePerTotalAmount;
    double totalMoneyToChange;
    final static Logger logger = Logger.getLogger(CalculatorImpl.class);

    //initial method
//    @Override
//    public double calculateSumForChange() throws IOException, ParseException {
//        VendingMachineImpl vendingMachine = new VendingMachineImpl();
//        Helper helper = new Helper();
//
//
//        id = helper.checkId();
//
//        amountFromUser = helper.checkAmount();
//
//        price = helper.priceFromList();
//        System.out.println("Price = " + price);
//
//        this.pricePerTotalAmount = price * amountFromUser;
//
//        logger.info("start of calculation");
//
//        this.moneyEnteredFromUser = helper.checkMoney();
//
//        if (moneyEnteredFromUser >= pricePerTotalAmount) {
//            totalMoneyToChange = moneyEnteredFromUser - pricePerTotalAmount;
//            System.out.println("Your change is = " + totalMoneyToChange);
//            logger.info("The calculation was successfully done");
//            return totalMoneyToChange;
//
//        } else {
//            System.out.println("You don't have enough money");
//            logger.info("The user hasn't enough money");
//        }
//
//        System.out.println("Your change is = " + moneyEnteredFromUser);
//        logger.info("The calculation was successfully done");
//        return moneyEnteredFromUser;
//
//    }


    @Override
    public double calculateSumForChange() throws IOException, ParseException {
        Helper helper = new Helper();
        id = helper.checkId();
        amountFromUser = helper.checkAmount();
        price = helper.priceFromList();
        moneyEnteredFromUser = helper.checkMoney();

        pricePerTotalAmount = price * amountFromUser;

        if (moneyEnteredFromUser >= pricePerTotalAmount) {
            totalMoneyToChange = moneyEnteredFromUser - pricePerTotalAmount;
            return totalMoneyToChange;
        } else {
            return moneyEnteredFromUser;
        }
    }
}
