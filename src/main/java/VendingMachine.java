import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface VendingMachine {
    void  displayProductList();
    int  selectProduct() throws IOException, ParseException;
    int selectAmount()throws IOException, ParseException ;
    void displayEnterDollarsMessage();
    double enterDollars();


}
