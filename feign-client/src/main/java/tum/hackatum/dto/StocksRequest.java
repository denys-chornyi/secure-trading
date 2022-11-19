package tum.hackatum.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StocksRequest {

    private List<Stock> data;
    private String status;

}
