import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
    private String name;
    private int amount;
    private String price;

    public Item(String name, int amount, String price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
