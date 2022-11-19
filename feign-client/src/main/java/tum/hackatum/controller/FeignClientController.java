package tum.hackatum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tum.hackatum.dto.PriceResponse;
import tum.hackatum.dto.StocksResponse;
import tum.hackatum.service.FeignClientService;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/feign-client")
@Import(FeignClientsConfiguration.class)
public class FeignClientController {

    @Autowired
    private FeignClientService feignClientService;

    @GetMapping("/stocks/price/{symbol}")
    public ResponseEntity<PriceResponse> getPrice(@PathVariable String symbol) throws URISyntaxException {
        return ResponseEntity.ok()
                .body(feignClientService.getPrise(symbol));
    }


    @GetMapping("/stocks")
    public ResponseEntity<StocksResponse> getStocks() throws URISyntaxException {
        return ResponseEntity.ok()
                .body(feignClientService.getStocks());
    }

    @GetMapping("/stocks/symbol/{symbol}")
    public ResponseEntity<StocksResponse> getStocksBySymbol(@PathVariable String symbol) throws URISyntaxException {
        return ResponseEntity.ok()
                .body(feignClientService.getStocksBySymbol(symbol));
    }

    @GetMapping("/stocks/country/{country}")
    public ResponseEntity<StocksResponse> getStocksByCounty(@PathVariable String country) throws URISyntaxException {
        return ResponseEntity.ok()
                .body(feignClientService.getStocksByCountry(country));
    }

}
