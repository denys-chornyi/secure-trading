package tum.hackatum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tum.hackatum.dto.StocksResponse;
import tum.hackatum.service.FeignClientService;

@RestController
@RequestMapping("/api/feign-client")
public class FeignClientController {

    @Autowired
    private FeignClientService feignClientService;

    @GetMapping("/stocks")
    public ResponseEntity<StocksResponse> getStocks() {
        return new ResponseEntity<>(feignClientService.getStocks(), HttpStatus.OK);
    }

    @GetMapping("/stocks/symbol/{symbol}")
    public ResponseEntity<StocksResponse> getStocksBySymbol(@PathVariable String symbol) {
        return new ResponseEntity<>(feignClientService.getStocksBySymbol(symbol), HttpStatus.OK);
    }

    @GetMapping("/stocks/name/{name}")
    public ResponseEntity<StocksResponse> getStocksByName(@PathVariable String name) {
        return new ResponseEntity<>(feignClientService.getStocksByName(name), HttpStatus.OK);
    }

    @GetMapping("/stocks/country/{country}")
    public ResponseEntity<StocksResponse> getStocksByCountry(@PathVariable String country) {
        return new ResponseEntity<>(feignClientService.getStocksByCountry(country), HttpStatus.OK);
    }

}
