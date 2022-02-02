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
//            System.out.print("You selected -> ");
            System.out.println(MyJsonParser.itemList.get(id));
            logger.info("Id have been selected");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("You selected a wrong item");
            logger.error(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }


    public  int checkAmount(){

        try {
//            System.out.print("You selected -> ");
            System.out.println(MyJsonParser.itemList.get(id));
            this.amountFromUser = vendingMachine.selectAmount();
            logger.info("The amount have been selected");
            if(amountFromUser > MyJsonParser.itemList.get(id).getAmount() ||
                    amountFromUser<0){
                System.out.println("Wrong amount");
                amountFromUser = -1;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("you can't insert amount because You selected a wrong item");
            logger.error(e);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return amountFromUser;
    }


    public double checkMoney() {

        this.moneyEnteredFromUser = vendingMachine.enterDollars();
        if (moneyEnteredFromUser >= 0) {
            return moneyEnteredFromUser;
        }

        return -1;
    }

    public double priceFromList() {
        double price = 0;
        try {
            logger.info("Start parsing the price from list");
            this.priceForPars = String.valueOf(MyJsonParser.itemList.get(id));
            Pattern pattern = Pattern.compile("\\w+([0-9\\.][0-9]+)");
            Matcher matcher = pattern.matcher(priceForPars);

            for (int i = 0; i < matcher.groupCount(); i++) {
                matcher.find();
                price = Double.parseDouble(matcher.group());
                logger.info("Successful parsing");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You can't parse this price because You selected a wrong item");
            logger.info(e);
        }

        return price;
    }

}
