package tum.hackatum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tum.hackatum.dto.StocksRequest;
import tum.hackatum.dto.StocksResponse;
import tum.hackatum.feignapiclient.FeignApiClient;

import java.util.stream.Collectors;

@Service
public class FeignClientService {

    @Autowired
    private FeignApiClient feignApiClient;

    public StocksResponse getStocks() {
        StocksRequest feignClientRequest = feignApiClient.getStocks();
        return StocksResponse.builder()
                .stocks(feignClientRequest.getData())
                .status(feignClientRequest.getStatus())
                .build();
    }

    public StocksResponse getStocksBySymbol(String symbol) {
        StocksRequest feignClientRequest = feignApiClient.getStocks();
        return StocksResponse.builder()
                .stocks(feignClientRequest.getData().stream()
                        .filter(stock -> stock.getSymbol().equals(symbol))
                        .collect(Collectors.toList()))
                .status(feignClientRequest.getStatus())
                .build();
    }

    public StocksResponse getStocksByName(String name) {
        StocksRequest feignClientRequest = feignApiClient.getStocks();
        return StocksResponse.builder()
                .stocks(feignClientRequest.getData().stream()
                        .filter(stock -> stock.getName().equals(name))
                        .collect(Collectors.toList()))
                .status(feignClientRequest.getStatus())
                .build();
    }

    public StocksResponse getStocksByCountry(String country) {
        StocksRequest feignClientRequest = feignApiClient.getStocks();
        return StocksResponse.builder()
                .stocks(feignClientRequest.getData().stream()
                        .filter(stock -> stock.getCountry().equals(country))
                        .collect(Collectors.toList()))
                .status(feignClientRequest.getStatus())
                .build();
    }
}
