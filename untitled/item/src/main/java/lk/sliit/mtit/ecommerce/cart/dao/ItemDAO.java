package lk.sliit.mtit.ecommerce.cart.dao;

import lk.sliit.mtit.ecommerce.cart.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<Item, Long> {
    Item getByItemId(Long itemId);

   void deleteItemByItemId(Long itemId);
    @Query(value = "SELECT itemId FROM Item ORDER BY itemId DESC LIMIT 1", nativeQuery = true)
    Long getLastItemId();
}
