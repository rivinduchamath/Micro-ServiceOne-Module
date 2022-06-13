package lk.sliit.mtit.ecommerce.cart.controller;

import lk.sliit.mtit.ecommerce.cart.dto.ItemDTO;
import lk.sliit.mtit.ecommerce.cart.service.ItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemBO itemBO;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value ="/saveItem",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String saveItem( @RequestBody  ItemDTO itemDTO){
        ItemDTO itemDTO2 = itemBO.saveItem(itemDTO);
        System.out.println(itemDTO2+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "\"" + itemDTO2.getItemId() + "\"";
    }

    @GetMapping(value="/{itemId}")
    public ItemDTO getItems(@PathVariable("itemId") Long itemId){
        return itemBO.getItem(itemId);
    }

    @DeleteMapping("/delete/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId){
        itemBO.deleteItem(itemId);
    }

    @PutMapping("/{itemId}")
    public void updateItem(@PathVariable Long itemId,
                           @RequestBody ItemDTO itemDTO){
        itemDTO.setItemId(itemId);
        itemBO.updateItem(itemDTO);
    }
   // @CrossOrigin(origins = "http://localhost:8546/items/getAll")
    @GetMapping("/getAll")
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> allItem = itemBO.getAllItem();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",allItem.size() + "");
        return new ResponseEntity<>(allItem,httpHeaders,HttpStatus.OK);
    }
}
