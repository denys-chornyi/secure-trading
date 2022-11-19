package tum.hackatum.orderbookservice.service;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tum.hackatum.orderbookservice.dto.OrderBookUpdateRequest;
import tum.hackatum.orderbookservice.dto.OrderBookUpdateResponse;
import tum.hackatum.orderbookservice.dto.ValidationResponse;
import tum.hackatum.orderbookservice.model.OrderBook;
import tum.hackatum.orderbookservice.orderbookserviceapiclient.OrderBookServiceApiClient;
import tum.hackatum.orderbookservice.repository.OrderBookRepository;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class OrderBookService {

    private OrderBookServiceApiClient orderBookServiceApiClient;

    @Autowired
    private OrderBookRepository orderBookRepository;

    @Autowired
    public OrderBookService(Decoder decoder, Encoder encoder) {
        orderBookServiceApiClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(Target.EmptyTarget.create(OrderBookServiceApiClient.class));
    }

    public OrderBookUpdateResponse updateOrderBook(OrderBookUpdateRequest orderBookUpdateRequest) throws URISyntaxException {
        ValidationResponse validationResponse = orderBookServiceApiClient.validate(new URI("http://localhost:6969/api/user/validate/" + orderBookUpdateRequest.getUser().getUsername() + "/" + orderBookUpdateRequest.getUser().getPassword()));
            if (validationResponse.isValid()) {
                OrderBook orderBook = OrderBook.builder()
                        .side(orderBookUpdateRequest.getSide())
                        .type(orderBookUpdateRequest.getType())
                        .symbol(orderBookUpdateRequest.getSymbol())
                        .quantity(orderBookUpdateRequest.getQuantity())
                        .price(orderBookUpdateRequest.getPrice())
                        .username(orderBookUpdateRequest.getUser().getUsername())
                        .build();
                orderBookRepository.save(orderBook);
                return OrderBookUpdateResponse.builder()
                        .response("Order Book created")
                        .httpStatus(HttpStatus.OK)
                        .build();

            } else {
                return OrderBookUpdateResponse.builder()
                        .response("Unable to create Order Book")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build();

            }
    }
}
