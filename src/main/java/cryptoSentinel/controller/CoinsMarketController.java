package cryptoSentinel.controller;

import cryptoSentinel.dto.query.CoinsMarketsQuery;
import cryptoSentinel.service.CoinsMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/get")
@RequiredArgsConstructor
public class CoinsMarketController {

    private final CoinsMarketService coinsMarketService;

    @GetMapping(value = "/market", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> marketIngestion(CoinsMarketsQuery query) {
        return coinsMarketService.getCoinMarket(query);
    }

}
