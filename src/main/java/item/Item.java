package item;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    private String name;
    private Integer amount;
    private String price;
}
