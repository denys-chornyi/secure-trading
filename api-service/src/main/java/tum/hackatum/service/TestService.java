package tum.hackatum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tum.hackatum.userservice.api.TradingAPI;
import tum.hackatum.userservice.model.Response;

@Service
public class TestService {

    @Autowired
    private TradingAPI tradingAPI;

    public Response getData() {
        System.out.println("jknwjnwjb");
        return tradingAPI.getData();
    }

}
