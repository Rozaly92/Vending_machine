import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorImpl implements Calculator {
    private double moneyEnteredFromUser;
    int id;
    int amountFromUser;
    double price;

    @Override
    public double calculateSumForChange() throws IOException, ParseException {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        this.id = vendingMachine.selectProduct();
        this.amountFromUser = vendingMachine.selectAmount();
        this.moneyEnteredFromUser = vendingMachine.enterDollars();


        String priceForPars = String.valueOf(MyJsonParser.itemList.get(id));
        System.out.println(MyJsonParser.itemList.get(id));
        System.out.println("Amount = " + amountFromUser);


        Pattern pattern = Pattern.compile("\\w+([0-9\\.][0-9]+)");
        Matcher matcher = pattern.matcher(priceForPars);
        for (int i = 0; i < matcher.groupCount(); i++) {
            matcher.find();
            //System.out.println("Price = " + matcher.group());
            price = Double.parseDouble(matcher.group());
        }

        System.out.println("Price = " + price);

        //price = regexpForPrice();
        double pricePerTotalAmount = price * amountFromUser;

        System.out.println("Price for amount = " + pricePerTotalAmount);

        double totalMoneyToChange = moneyEnteredFromUser - pricePerTotalAmount;

        System.out.println("Your change is = " + totalMoneyToChange);

        return totalMoneyToChange;
    }


}
