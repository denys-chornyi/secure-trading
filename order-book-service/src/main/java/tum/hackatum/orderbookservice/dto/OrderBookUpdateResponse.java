package tum.hackatum.orderbookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderBookUpdateResponse {

    private String response;
    private HttpStatus httpStatus;

}
