package tum.hackatum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String symbol;
    private List<String> available_exchanges;
    private String currency_base;
    private String currency_quote;

}
