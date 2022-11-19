package tum.hackatum.orderbookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBookUpdateRequest {

    private String side;
    private String type;
    private String symbol;
    private Integer quantity;
    private Float price;
    private UserDto user;

}
