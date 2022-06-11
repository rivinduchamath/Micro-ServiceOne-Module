package lk.sliit.mtit.ecommerce.cart.service;

import lk.sliit.mtit.ecommerce.cart.dto.CartDTO;
import lk.sliit.mtit.ecommerce.cart.valueObjects.ResponseTemplateVO;

import java.util.List;

public interface CartBO {
    CartDTO saveCart(CartDTO cartDTO);

    CartDTO getCart(Long cartId);

    void deleteCart(Long cartId);

    void updateCart(CartDTO cartDTO);

    List<CartDTO> getAllItem();

    ResponseTemplateVO getCartWithItemAndCustomer(Long id);
}
