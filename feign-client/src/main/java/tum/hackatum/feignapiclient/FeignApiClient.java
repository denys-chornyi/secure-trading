package tum.hackatum.feignapiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tum.hackatum.dto.StocksRequest;

@FeignClient(name = "feign-client", url = "https://api.twelvedata.com")
public interface FeignApiClient {

    @GetMapping("/stocks?apikey=35a13d11d5c547e88c907ed534d516a68")
    StocksRequest getStocks();

}
