import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    VendingMachineImpl vendingMachine = new VendingMachineImpl();
    double moneyEnteredFromUser;
    int id;
    int amountFromUser;
    String priceForPars;

    final static Logger logger = Logger.getLogger(Helper.class);


    public int checkId() {
        try {
            this.id = vendingMachine.selectProduct();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.info("The item has been selected "+ MyJsonParser.itemList.get(id));

        return id;
    }


    public int checkAmount() {
        try {
            this.amountFromUser = vendingMachine.selectAmount();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.info("The amount "+ amountFromUser +" has been selected");

        return amountFromUser;
    }


    public double checkMoney() {

        this.moneyEnteredFromUser = vendingMachine.enterDollars();
        if (moneyEnteredFromUser >= 0) {
            logger.info("The user inserted " + moneyEnteredFromUser + " $");
            return moneyEnteredFromUser;
        }
        return -1;
    }

    public double priceFromList() {
        double price = 0;
        try {
            this.priceForPars = String.valueOf(MyJsonParser.itemList.get(id));
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


    public void showDetails()  {

        System.out.println("You selected the item = " + MyJsonParser.itemList.get(id));
         System.out.println("The amount = " + amountFromUser);

        CalculatorImpl calculator = new CalculatorImpl();
        calculator.calculateTotalPrice();
    }


    public void update() {
        String name = MyJsonParser.itemList.get(id).getName();
        Integer amount = MyJsonParser.itemList.get(id).getAmount();
        String price = MyJsonParser.itemList.get(id).getPrice();
        Item item = new Item(name, amount, price);
        int idForUpdateAmountInJSonFile = MyJsonParser.itemList.get(id).getAmount() - amountFromUser;
        MyJsonParser.updateList(item, idForUpdateAmountInJSonFile);
    }
}
