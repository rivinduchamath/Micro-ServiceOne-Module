package lk.sliit.mtit.ecommerce.cart.valueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long itemId;
    private String itemName;
    private double itemPrice;
    private int itemQty;
    private Date date;
    private Long sellerId;

}
