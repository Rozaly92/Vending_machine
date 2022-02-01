public class CalculatorImpl implements Calculator {
    private double moneyEnteredFromUser;  //will be removed
    int id;//will be removed
    int amountFromUser;//will be removed
    double price;
    String priceForPars = null;
    double pricePerTotalAmount;
    double totalMoneyToChange;

    @Override
    public double calculateSumForChange() {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        Helper helper = new Helper();

        id = helper.checkId();
       amountFromUser = helper.checkAmount();

        price = helper.priceFromList();
        System.out.println("Price = " + price);

        this.pricePerTotalAmount = price * amountFromUser;


        this.moneyEnteredFromUser = helper.checkMoney();
        if (moneyEnteredFromUser >= pricePerTotalAmount) {
                totalMoneyToChange = moneyEnteredFromUser - pricePerTotalAmount;
            System.out.println("Your change is = " + totalMoneyToChange);
            return totalMoneyToChange;

            } else {
                System.out.println("You don't have enough money");
            }

        System.out.println("Your change is = " + moneyEnteredFromUser);
        return moneyEnteredFromUser;

    }

}
