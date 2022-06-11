package lk.sliit.mtit.ecommerce.cart.service.serviceimpl;

import lk.sliit.mtit.ecommerce.cart.dao.CartDAO;
import lk.sliit.mtit.ecommerce.cart.dto.CartDTO;
import lk.sliit.mtit.ecommerce.cart.entity.Cart;
import lk.sliit.mtit.ecommerce.cart.service.CartBO;
import lk.sliit.mtit.ecommerce.cart.valueObjects.Customer;
import lk.sliit.mtit.ecommerce.cart.valueObjects.Item;
import lk.sliit.mtit.ecommerce.cart.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@Slf4j
public class CartBOImpl implements CartBO {
    @Autowired
    private CartDAO cartDAO;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CartDTO saveCart(CartDTO cartDTO) {
        cartDAO.save(new Cart(
                cartDTO.getCartId(),
                cartDTO.getUserId(),
                cartDTO.getItemId(),
                cartDTO.getQty(),
                cartDTO.getDate()
        ));
        log.info("Added to the Cart");
        return cartDTO;
    }

    @Override
    public CartDTO getCart(Long cartId) {
        Cart cart = cartDAO.getByCartId(cartId);
        return new CartDTO(
                cart.getCartId(),
                cart.getUserId(),
                cart.getItemId(),
                cart.getQty(),
                cart.getDate()
        );
    }

    @Override
    public void deleteCart(Long cartId) {
        try{
            cartDAO.deleteCartByCartId(cartId);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateCart(CartDTO cartDTO) {
        cartDAO.save(new Cart(
                cartDTO.getCartId(),
                cartDTO.getUserId(),
                cartDTO.getItemId(),
                cartDTO.getQty(),
                cartDTO.getDate()
        ));
        log.info("Updated the Cart");
    }

    @Transactional(readOnly = true)
    @Override
    public List<CartDTO> getAllItem() {
        List<Cart> carts = cartDAO.findAll();
        List<CartDTO> cartDTOS = new ArrayList<>();
        for (Cart cart: carts
             ) {
            cartDTOS.add(new CartDTO(
                    cart.getCartId(),
                    cart.getUserId(),
                    cart.getItemId(),
                    cart.getQty(),
                    cart.getDate()
            ));
        }
        return cartDTOS;
    }
    @Override
    public ResponseTemplateVO getCartWithItemAndCustomer(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Cart cart = cartDAO.getByCartId(id);


        Item item =
                restTemplate.getForObject("http://ITEM-SERVICE/items/" +
                        cart.getItemId(), Item.class);
        Customer customer =
                restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" +
                        cart.getUserId(), Customer.class);


        vo.setCustomer(customer);
        vo.setCart(cart);
        vo.setItem(item);
        return vo;
    }
}
