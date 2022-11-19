package tum.hackatum.orderbookservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table (name = "t_order_books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String side;
    private String type;
    private String symbol;
    private Integer quantity;
    private Float price;
    private String username;
    //private LocalTime localTime;

}
