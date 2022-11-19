package tum.hackatum.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StocksDto {

    private List<StockDto> data;
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockDto {

        private String symbol;
        private String name;
        private String currency;
        private String exchange;
        private String mic_code;
        private String country;
        private String type;

    }
}
