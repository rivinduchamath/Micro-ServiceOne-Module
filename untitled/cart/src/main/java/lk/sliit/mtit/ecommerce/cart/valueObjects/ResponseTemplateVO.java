package lk.sliit.mtit.ecommerce.cart.valueObjects;

import lk.sliit.mtit.ecommerce.cart.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Item item;
    private Cart cart;
    private Customer customer;
}
