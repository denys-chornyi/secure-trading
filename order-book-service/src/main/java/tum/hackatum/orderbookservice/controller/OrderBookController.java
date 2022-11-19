package tum.hackatum.orderbookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tum.hackatum.orderbookservice.dto.OrderBookUpdateRequest;
import tum.hackatum.orderbookservice.dto.OrderBookUpdateResponse;
import tum.hackatum.orderbookservice.service.OrderBookService;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/order-book")
@Import(FeignClientsConfiguration.class)
public class OrderBookController {

    @Autowired
    private OrderBookService orderBookService;

    @PostMapping("/update")
    public ResponseEntity<OrderBookUpdateResponse> updateOrderBook(@RequestBody OrderBookUpdateRequest orderBookUpdateRequest) throws URISyntaxException {
        OrderBookUpdateResponse orderBookUpdateResponse = orderBookService.updateOrderBook(orderBookUpdateRequest);
        return new ResponseEntity<>(orderBookUpdateResponse, orderBookUpdateResponse.getHttpStatus());
    }

}
