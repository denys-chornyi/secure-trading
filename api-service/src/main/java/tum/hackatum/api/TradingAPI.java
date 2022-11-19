package tum.hackatum.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tum.hackatum.userservice.model.Data;
import tum.hackatum.userservice.model.Response;

import java.util.List;

@FeignClient(name = "trading-service", url = "https://api.twelvedata.com")
public interface TradingAPI {

    @GetMapping("/cryptocurrencies?symbol=BTC/USD&apikey=35a13d11d5c547e88c907ed534d516a6")
    Response getData();

}
