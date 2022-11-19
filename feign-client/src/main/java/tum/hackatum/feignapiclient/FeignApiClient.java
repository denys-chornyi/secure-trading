package tum.hackatum.feignapiclient;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import tum.hackatum.dto.PriceDto;
import tum.hackatum.dto.StocksDto;

import java.net.URI;

@FeignClient(name = "feign-client")
public interface FeignApiClient {
    @RequestLine("GET")
    StocksDto getStocks(URI baseUri);

    @RequestLine("GET")
    PriceDto getPrice(URI baseUri);



}
