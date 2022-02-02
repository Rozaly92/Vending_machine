import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface VendingMachine {
    void  displayProductList();
    int selectProduct() throws IOException, ParseException;
    int selectAmount()throws IOException, ParseException ;
    void displayEnterDollarsMessage();
    double enterDollars();


}
