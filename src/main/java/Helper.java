import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
   // MyJsonParser myJsonParser = new MyJsonParser();
   VendingMachineImpl vendingMachine = new VendingMachineImpl();
     double moneyEnteredFromUser;
    int id;
    int amountFromUser;
    String priceForPars;

    public  int  checkId(){
        try {
            this.id = vendingMachine.selectProduct();
//            System.out.print("You selected -> ");
            System.out.println(MyJsonParser.itemList.get(id));
//            this.amountFromUser = vendingMachine.selectAmount();
//            if(amountFromUser > MyJsonParser.itemList.get(id).getAmount() ||
//                    amountFromUser<0){
//                System.out.println("Wrong amount");
//            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You selected a wrong item");
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("You selected a wrong item");
//        }
        return id;
    }

    public  int checkAmount(){

        try {
//            System.out.print("You selected -> ");
            System.out.println(MyJsonParser.itemList.get(id));
            this.amountFromUser = vendingMachine.selectAmount();
            if(amountFromUser > MyJsonParser.itemList.get(id).getAmount() ||
            amountFromUser<0){
                System.out.println("Wrong amount");
                amountFromUser = -1;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("you can't insert amount because You selected a wrong item");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return amountFromUser;
    }

    public double checkMoney(){

        this.moneyEnteredFromUser = vendingMachine.enterDollars();
        if(moneyEnteredFromUser >= 0){
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
                //System.out.println("Price = " + matcher.group());
                price = Double.parseDouble(matcher.group());
            }
            //return price;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You can't parse this price because You selected a wrong item");
        }

//        this.priceForPars = String.valueOf(MyJsonParser.itemList.get(id));


//            Pattern pattern = Pattern.compile("\\w+([0-9\\.][0-9]+)");
//            Matcher matcher = pattern.matcher(priceForPars);
//            double price = 0;
//            for (int i = 0; i < matcher.groupCount(); i++) {
//                matcher.find();
//                //System.out.println("Price = " + matcher.group());
//                price = Double.parseDouble(matcher.group());
//            }
           return price;
        }

}
