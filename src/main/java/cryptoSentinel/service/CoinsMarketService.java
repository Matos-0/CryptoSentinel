package cryptoSentinel.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cryptoSentinel.config.UriProperties;
import cryptoSentinel.dto.CoinsMarketsDTO;
import cryptoSentinel.dto.query.CoinsMarketsQuery;
import cryptoSentinel.repository.CoinsMarketRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@AllArgsConstructor
public class CoinsMarketService {

    private final WebClient coingeckoWebClient;
    private final UriProperties uriProperties;
    private final CoinsMarketRepository coinsMarketRepository;
    private static final Logger log = LoggerFactory.getLogger(CoinsMarketService.class);
    private final ObjectMapper objectMapper;

    public Flux<CoinsMarketsDTO> getCoinsMarket(CoinsMarketsQuery query) {

        Map<String, Object> queryMap = objectMapper.convertValue(query, new TypeReference<Map<String, Object>>() {
        });

        return coingeckoWebClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(uriProperties.getCoinMarketUrl());
                    queryMap.forEach((key, value) -> {
                        if (value != null) uriBuilder.queryParam(key, value);
                    });
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(CoinsMarketsDTO.class);
    }

}
