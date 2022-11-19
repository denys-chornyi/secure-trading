package tum.hackatum.orderbookservice.orderbookserviceapiclient;

import feign.RequestLine;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import tum.hackatum.orderbookservice.dto.ValidationResponse;

import java.net.URI;

@FeignClient(name = "order-book-service")
public interface OrderBookServiceApiClient {

    @RequestLine("POST")
    ValidationResponse validate(URI uri);

}
