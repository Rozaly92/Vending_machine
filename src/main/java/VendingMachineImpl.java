import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class VendingMachineImpl implements VendingMachine {
    private Scanner scanner = new Scanner(System.in);
    private int amountChoseFromUser;
    private double moneyEnteredFromUser;
    private int idForSelectedProduct;
    MyJsonParser dataFromJson = new MyJsonParser();
    CalculatorImpl calculator = new CalculatorImpl();

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getAmountChoseFromUser() {
        return amountChoseFromUser;
    }

    public void setAmountChoseFromUser(int amountChoseFromUser) {
        this.amountChoseFromUser = amountChoseFromUser;
    }

    public double getMoneyEnteredFromUser() {
        return moneyEnteredFromUser;
    }

    public void setMoneyEnteredFromUser(double moneyEnteredFromUser) {
        this.moneyEnteredFromUser = moneyEnteredFromUser;
    }

    public int getIdForSelectedProduct() {
        return idForSelectedProduct;
    }

    public void setIdForSelectedProduct(int idForSelectedProduct) {
        this.idForSelectedProduct = idForSelectedProduct;
    }

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
    public int selectProduct() throws IOException, ParseException {
        System.out.println("Select product, please!");
        this.idForSelectedProduct = scanner.nextInt();
        return idForSelectedProduct - 1; //idForSelectedProduct-1 because list starts from index 0
    }

    @Override
    public int selectAmount() throws IOException, ParseException {
        System.out.println("Input amount, please!");
        this.amountChoseFromUser = scanner.nextInt();
        return amountChoseFromUser;
    }

    @Override
    public void displayEnterDollarsMessage() {
        System.out.println("You entered " + enterDollars() + " $!");
    }

    @Override
    public double enterDollars() {
        System.out.println("Enter money");
        moneyEnteredFromUser = scanner.nextDouble();
        return moneyEnteredFromUser;
    }
}
