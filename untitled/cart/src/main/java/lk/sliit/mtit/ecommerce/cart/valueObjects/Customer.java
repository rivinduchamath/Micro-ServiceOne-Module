/**
 * @author - Chamath_Wijayarathna
 * Date :6/11/2022
 */


package lk.sliit.mtit.ecommerce.cart.valueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long customerId;
    private String name;
    private String address;
    private Date date;
    private int age;
    private int telephone;


}
