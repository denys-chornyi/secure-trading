package tum.hackatum.service;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tum.hackatum.dto.PriceDto;
import tum.hackatum.dto.PriceResponse;
import tum.hackatum.dto.StocksDto;
import tum.hackatum.dto.StocksResponse;
import tum.hackatum.feignapiclient.FeignApiClient;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class FeignClientService {

    private FeignApiClient feignApiClient;

    @Autowired
    public FeignClientService(Decoder decoder, Encoder encoder) {
        feignApiClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(Target.EmptyTarget.create(FeignApiClient.class));

    }

    public PriceResponse getPrise(String symbol) throws URISyntaxException {
        PriceDto priceDto = feignApiClient
                .getPrice(new URI("https://api.twelvedata.com/price?symbol=" + symbol + "&apikey=35a13d11d5c547e88c907ed534d516a6"));
        return PriceResponse.builder()
                .price(priceDto.getPrice())
                .build();
    }

    public StocksResponse getStocks() throws URISyntaxException {
        StocksDto stocksDto = feignApiClient
                .getStocks(new URI("https://api.twelvedata.com/stocks?apikey=35a13d11d5c547e88c907ed534d516a6"));
        return StocksResponse.builder()
                .stocks(stocksDto.getData())
                .status(stocksDto.getStatus())
                .build();
    }

    public StocksResponse getStocksBySymbol(String symbol) throws URISyntaxException {
        StocksDto stocksDto = feignApiClient
                .getStocks(new URI("https://api.twelvedata.com/stocks?apikey=35a13d11d5c547e88c907ed534d516a6&symbol=" + symbol ));
        return StocksResponse.builder()
                .stocks(stocksDto.getData())
                .status(stocksDto.getStatus())
                .build();

    }

    public StocksResponse getStocksByCountry(String country) throws URISyntaxException {
        StocksDto stocksDto = feignApiClient
                .getStocks(new URI("https://api.twelvedata.com/stocks?apikey=35a13d11d5c547e88c907ed534d516a6&country=" + country));
        return StocksResponse.builder()
                .stocks(stocksDto.getData())
                .status(stocksDto.getStatus())
                .build();

    }

}
